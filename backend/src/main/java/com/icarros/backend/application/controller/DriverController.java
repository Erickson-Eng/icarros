package com.icarros.backend.application.controller;

import com.icarros.backend.application.dto.api.DriverApi;
import com.icarros.backend.application.dto.api.DriverTableApi;
import com.icarros.backend.application.dto.api.ResultsApi;
import com.icarros.backend.domain.service.IDriverService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/formula1/driver")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DriverController {

    private IDriverService driverService;

    @ApiOperation(value = "Get all drivers")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = DriverTableApi.class)
    })
    @GetMapping
    public ResponseEntity<DriverTableApi> findAllDrivers(){
        List<DriverApi> drivers = driverService.listAllDrivers();
        DriverTableApi driverTableApi = new DriverTableApi(drivers);
        return ResponseEntity.ok().body(driverTableApi);
    }

    @ApiOperation(value = "get a pilot by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = DriverApi.class)
    })
    @GetMapping(path = "/{driverId}")
    public ResponseEntity<DriverApi> findDriverById(@PathVariable String driverId){
        DriverApi driverApi = driverService.findDriverById(driverId);
        return ResponseEntity.ok().body(driverApi);
    }
}
