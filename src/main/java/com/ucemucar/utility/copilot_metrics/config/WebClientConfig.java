package com.ucemucar.utility.copilot_metrics.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${github.api.token}")
    private String githubApiToken;
    @Value("${github.api.base-url}")
    private String githubApiBaseUrl;

    @Bean
    public WebClient webClient() {

        return WebClient.builder().baseUrl(githubApiBaseUrl).defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + githubApiToken).defaultHeader(HttpHeaders.ACCEPT, "application/vnd.github+json").build();
    }

}