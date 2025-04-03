package com.ucemucar.utility.copilot_metrics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LanguageMetrics {

    @JsonProperty("name")
    private String name;
    @JsonProperty("total_engaged_users")
    private int totalEngagedUsers;
    @JsonProperty("total_code_suggestions")
    private int totalCodeSuggestions;
    @JsonProperty("total_code_acceptances")
    private int totalCodeAcceptances;
    @JsonProperty("total_code_lines_suggested")
    private int totalCodeLinesSuggested;
    @JsonProperty("total_code_lines_accepted")
    private int totalCodeLinesAccepted;

}