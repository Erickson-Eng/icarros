package com.icarros.backend.application.dto.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConstructorApi {
    private String constructorId;
    private String url;
    private String name;
    private String nationality;
}
