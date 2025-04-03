package com.ucemucar.utility.copilot_metrics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EditorMetrics {

    @JsonProperty("name")
    private String name;
    @JsonProperty("total_engaged_users")
    private int totalEngagedUsers;
    @JsonProperty("models")
    private List<ModelMetrics> models;

}