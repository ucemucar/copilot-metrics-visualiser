package com.ucemucar.utility.copilot_metrics.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CombinedResponse {

    private CopilotSeatsResponse seatsResponse;
    private List<DailyMetricsResponse> dailyMetrics;

}