package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RaceTableApi {
    private String season;
    private String round;

    @JsonProperty("Races")
    private List<RaceApi> races;
}
