package com.icarros.backend.domain.service.impl;

import com.icarros.backend.application.dto.api.CircuitApi;
import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.application.dto.api.RaceApi;
import com.icarros.backend.domain.service.ICircuitService;
import com.icarros.backend.domain.service.IFormulaOneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CircuitServiceImpl implements ICircuitService {

    private IFormulaOneService formulaOneService;

    @Override
    public List<CircuitApi> listAllCircuits() {
        FormulaOneApi api = formulaOneService.findFormulaOneApi();
        return api.getMrDataApi().getRaceTable().getRaces()
                .stream().map(RaceApi::getCircuitApi).collect(Collectors.toList());
    }
}
