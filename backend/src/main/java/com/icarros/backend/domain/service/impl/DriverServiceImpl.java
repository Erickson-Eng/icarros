package com.icarros.backend.domain.service.impl;

import com.icarros.backend.application.dto.api.DriverApi;
import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.application.dto.api.ResultApi;
import com.icarros.backend.domain.service.IDriverService;
import com.icarros.backend.domain.service.IFormulaOneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DriverServiceImpl implements IDriverService {

    private IFormulaOneService formulaOneService;

    @Override
    public List<DriverApi> listAllDrivers() {
        FormulaOneApi api = formulaOneService.findFormulaOneApi();
        List<List<DriverApi>> list = api.getMrDataApi().getRaceTable().getRaces()
                .stream().map(raceApi -> raceApi.getResultApiList()
                        .stream().map(ResultApi::getDriverApi).collect(Collectors.toList()))
                .collect(Collectors.toList());

        return list.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public DriverApi findDriverById(String driverId) {
        DriverApi object = null;
        List<DriverApi> drivers = listAllDrivers();
        for (DriverApi driverApi: drivers ) {
            if (Objects.equals(driverApi.getDriverId(), driverId))
                object = driverApi;
        }
        return object;
       }
}
