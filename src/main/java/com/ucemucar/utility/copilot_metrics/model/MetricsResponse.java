package com.ucemucar.utility.copilot_metrics.model;

import lombok.Data;

@Data
public class MetricsResponse {

    private String language;
    private int acceptedPrompts;
    private int acceptedLines;
    private double acceptanceRate;
    private String date;

}