package com.icarros.backend.domain.service;

import com.icarros.backend.application.dto.api.CircuitApi;

import java.util.List;

public interface ICircuitService {

    List<CircuitApi> listAllCircuits();
}
