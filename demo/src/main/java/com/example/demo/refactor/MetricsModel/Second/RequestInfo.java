package com.example.demo.refactor.MetricsModel.Second;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;
}
