package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RaceApi {

    private String season;
    private String round;
    private String url;
    private String raceName;

    @JsonProperty("Circuit")
    private CircuitApi circuitApi;

    @JsonProperty("Results")
    private List<ResultApi> resultApiList;

    private String date;
    private String time;
}
