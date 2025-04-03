package com.ucemucar.utility.copilot_metrics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyMetricsResponse {

    @JsonProperty("date")
    private String date;
    @JsonProperty("total_active_users")
    private int totalActiveUsers;
    @JsonProperty("total_engaged_users")
    private int totalEngagedUsers;
    @JsonProperty("copilot_ide_code_completions")
    private CodeCompletionsMetrics codeCompletionsMetrics;

}