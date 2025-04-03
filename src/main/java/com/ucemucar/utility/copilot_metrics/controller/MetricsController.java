package com.ucemucar.utility.copilot_metrics.controller;

import com.ucemucar.utility.copilot_metrics.model.CombinedResponse;
import com.ucemucar.utility.copilot_metrics.service.GitHubMetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MetricsController {

    private final GitHubMetricsService metricsService;

    @GetMapping("/")
    public String retrieve(Model model) {

        try {
            CombinedResponse combinedResponse = metricsService.fetchCombinedData().block();
            model.addAttribute("combinedResponse", combinedResponse);
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", "Error fetching data: " + e.getMessage());
            return "error";
        }
    }

}