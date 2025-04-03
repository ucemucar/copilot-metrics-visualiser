package com.ucemucar.utility.copilot_metrics.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Data
public class ModelMetrics {

    @JsonProperty("name")
    private String name;
    @JsonProperty("is_custom_model")
    private boolean isCustomModel;
    @JsonProperty("custom_model_training_date")
    private String customModelTrainingDate;
    @JsonProperty("total_engaged_users")
    private int totalEngagedUsers;
    @JsonProperty("languages")
    private List<LanguageMetrics> languages;
}