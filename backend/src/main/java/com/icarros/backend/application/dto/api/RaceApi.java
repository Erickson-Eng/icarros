package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
