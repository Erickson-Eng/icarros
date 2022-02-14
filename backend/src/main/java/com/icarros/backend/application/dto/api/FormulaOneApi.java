package com.icarros.backend.application.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FormulaOneApi {
    @JsonProperty("MRData")
    private MRDataApi mrDataApi;
}
