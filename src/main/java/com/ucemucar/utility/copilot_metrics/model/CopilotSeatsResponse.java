package com.ucemucar.utility.copilot_metrics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CopilotSeatsResponse {

    @JsonProperty("total_seats")
    private int totalSeats;
    private List<Seat> seats;

}