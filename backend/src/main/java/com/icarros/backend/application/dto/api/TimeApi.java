package com.icarros.backend.application.dto.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeApi {

    private String millis;
    private String time;
}
