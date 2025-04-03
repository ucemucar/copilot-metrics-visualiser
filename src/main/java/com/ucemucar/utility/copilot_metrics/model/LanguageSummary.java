package com.ucemucar.utility.copilot_metrics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LanguageSummary {

    @JsonProperty("name")
    private String name;
    @JsonProperty("total_engaged_users")
    private int totalEngagedUsers;

}