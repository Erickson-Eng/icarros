package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultApi {

    private String number;
    private String position;
    private String positionText;
    private String points;
    private String grid;
    private String laps;
    private String status;
    @JsonProperty("Driver")
    private DriverApi driverApi;
    @JsonProperty("Constructor")
    private ConstructorApi constructorApi;
    @JsonProperty("Time")
    private TimeApi timeApi;
    @JsonProperty("FastestLap")
    private FastestLapApi fastestLapApi;
}
