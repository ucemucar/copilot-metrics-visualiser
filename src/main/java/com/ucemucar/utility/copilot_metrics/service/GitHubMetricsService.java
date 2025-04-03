package com.ucemucar.utility.copilot_metrics.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ucemucar.utility.copilot_metrics.model.CombinedResponse;
import com.ucemucar.utility.copilot_metrics.model.CopilotSeatsResponse;
import com.ucemucar.utility.copilot_metrics.model.DailyMetricsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class GitHubMetricsService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    @Value("${github.api.seats.url}")
    private String githubApiSeatsUrl;
    @Value("${github.api.metrics.url}")
    private String githubApiMetricsUrl;

    public GitHubMetricsService(WebClient webClient, ObjectMapper objectMapper) {

        this.webClient = webClient;
        this.objectMapper = objectMapper;
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public Mono<CombinedResponse> fetchCombinedData() {

        Mono<CopilotSeatsResponse> seatsMono = getCopilotSeatsResponseMono();
        Mono<List<DailyMetricsResponse>> metricsMono = getMetricsMono();

        return Mono.zip(seatsMono, metricsMono).map(tuple -> new CombinedResponse(tuple.getT1(), tuple.getT2()));
    }

    private Mono<List<DailyMetricsResponse>> getMetricsMono() {

        return webClient.get().uri(githubApiMetricsUrl)
                .retrieve().bodyToMono(String.class)
                .map(json -> parseJson(json, new TypeReference<>() {

                }, "GitHub Metrics"));
    }

    private Mono<CopilotSeatsResponse> getCopilotSeatsResponseMono() {

        return webClient.get().uri(githubApiSeatsUrl)
                .retrieve().bodyToMono(String.class)
                .map(json -> parseJson(json, new TypeReference<>() {

        }, "GitHub Copilot Seats"));
    }

    private <T> T parseJson(String json, TypeReference<T> typeReference, String context) {

        try {
            return objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON for " + context + ": " + e.getMessage(), e);
        }
    }

}