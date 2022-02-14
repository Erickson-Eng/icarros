package com.icarros.backend.domain.service.impl;

import com.icarros.backend.application.dto.api.DriverApi;
import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.application.dto.api.RaceApi;
import com.icarros.backend.application.dto.api.ResultApi;
import com.icarros.backend.domain.service.IDriverService;
import com.icarros.backend.domain.service.IFormulaOneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DriverServiceJsonImpl implements IDriverService {

    private IFormulaOneService formulaOneService;

    @Override
    public List<List<DriverApi>> listAllDrivers() {
        FormulaOneApi api = formulaOneService.findFormulaOneApi();
        return api.getMrDataApi().getRaceTable().getRaces()
                .stream().map(raceApi -> raceApi.getResultApiList()
                        .stream().map(ResultApi::getDriverApi).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @Override
    public DriverApi findDriverById(String driverId) {
        return null;
    }

}
