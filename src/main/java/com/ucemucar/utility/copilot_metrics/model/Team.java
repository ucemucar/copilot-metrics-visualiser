package com.ucemucar.utility.copilot_metrics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Team {

    private int id;
    @JsonProperty("node_id")
    private String nodeId;
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    private String name;
    private String slug;
    private String description;
    private String privacy;
    @JsonProperty("notification_setting")
    private String notificationSetting;
    private String permission;
    @JsonProperty("members_url")
    private String membersUrl;
    @JsonProperty("repositories_url")
    private String repositoriesUrl;
    private Team parent;

}