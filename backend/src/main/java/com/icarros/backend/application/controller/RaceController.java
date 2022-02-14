package com.icarros.backend.application.controller;

import com.icarros.backend.application.dto.api.RaceApi;
import com.icarros.backend.application.dto.api.RaceTableApi;
import com.icarros.backend.application.dto.api.RacesApi;
import com.icarros.backend.application.exception.BadRequestException;
import com.icarros.backend.application.exception.NotFoundException;
import com.icarros.backend.domain.service.IRaceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/api/v1/formula1/races")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RaceController {

    private IRaceService raceService;

    @ApiOperation(value = "get race table")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = RaceTableApi.class)
    })
    @GetMapping
    public ResponseEntity<RaceTableApi> listRacesTable(){
        RaceTableApi raceTableApi = raceService.listRaceTable();
        return ResponseEntity.ok().body(raceTableApi);
    }

    @ApiOperation(value = "get the list of races per informed season")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = RacesApi.class),
            @ApiResponse(code = 404, message = "Not found", response = NotFoundException.class)
    })
    @GetMapping(path = "/{season}")
    public ResponseEntity<RacesApi> findRaceBySeason(@PathVariable @Valid String season){
        try
        {
            List<RaceApi> raceTableApi = raceService.findRaceBySeason(season);
            RacesApi racesApi = new RacesApi(raceTableApi);
            return ResponseEntity.ok().body(racesApi);
        }
        catch (NotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dont have data for season");
        }
    }

}
