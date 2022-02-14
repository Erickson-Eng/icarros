package com.icarros.backend.application.dto.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverApi {

    private String driverId;
    private String permanentNumber;
    private String code;
    private String url;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;
}
