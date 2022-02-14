package com.icarros.backend.application.controller;

import com.icarros.backend.application.dto.api.CircuitApi;
import com.icarros.backend.application.dto.api.CircuitTableApi;
import com.icarros.backend.domain.service.ICircuitService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/formula1/circuit")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CircuitController {

    private ICircuitService circuitService;


    @ApiOperation(value = "get all circuits")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = CircuitTableApi.class)
    })
    @GetMapping
    public ResponseEntity<CircuitTableApi> listAllCircuit(){
        List<CircuitApi> circuitApis = circuitService.listAllCircuits();
        CircuitTableApi circuitTableApi = new CircuitTableApi(circuitApis);
        return ResponseEntity.ok().body(circuitTableApi);
    }
}
