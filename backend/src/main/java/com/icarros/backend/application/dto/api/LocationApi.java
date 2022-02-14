package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationApi {

    private String lat;
    @JsonProperty("long")
    private String longitude;
    private String locality;
    private String country;
}
