package com.icarros.backend.domain.service;

import com.icarros.backend.application.dto.api.DriverApi;

import java.util.List;

public interface IDriverService {

    List<DriverApi> listAllDrivers();

    DriverApi findDriverById(String driverId);
}
