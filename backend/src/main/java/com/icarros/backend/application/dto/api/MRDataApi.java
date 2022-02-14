package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MRDataApi {
    private String xmlns;
    private String series;
    private String url;
    private String limit;
    private String offset;
    private String total;

    @JsonProperty("RaceTable")
    private RaceTableApi raceTable;
}
