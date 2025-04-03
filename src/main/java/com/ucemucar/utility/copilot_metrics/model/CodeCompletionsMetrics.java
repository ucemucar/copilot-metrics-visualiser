package com.ucemucar.utility.copilot_metrics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CodeCompletionsMetrics {

    @JsonProperty("total_engaged_users")
    private int totalEngagedUsers;
    @JsonProperty("languages")
    private List<LanguageSummary> languages;
    @JsonProperty("editors")
    private List<EditorMetrics> editors;

}