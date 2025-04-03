package com.ucemucar.utility.copilot_metrics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Seat {

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("pending_cancellation_date")
    private String pendingCancellationDate;
    @JsonProperty("last_activity_at")
    private String lastActivityAt;
    @JsonProperty("last_activity_editor")
    private String lastActivityEditor;
    @JsonProperty("plan_type")
    private String planType;
    private Assignee assignee;
    @JsonProperty("assigning_team")
    private Team assigningTeam;

}