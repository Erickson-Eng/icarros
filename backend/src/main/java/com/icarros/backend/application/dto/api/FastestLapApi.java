package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FastestLapApi {

    private String rank;
    private String lap;
    @JsonProperty("AverageSpeed")
    private AverageSpeedApi averageSpeedApi;
}
