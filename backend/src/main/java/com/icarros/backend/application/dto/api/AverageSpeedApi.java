package com.icarros.backend.application.dto.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AverageSpeedApi {
    private String units;
    private String speed;
}
