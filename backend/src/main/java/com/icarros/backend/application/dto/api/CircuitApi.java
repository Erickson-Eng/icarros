package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CircuitApi {
    private String circuitId;
    private String url;
    private String circuitName;

    @JsonProperty("Location")
    private LocationApi locationApi;
}
