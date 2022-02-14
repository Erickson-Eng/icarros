package com.icarros.backend.domain.service.impl;

import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.application.dto.api.RaceApi;
import com.icarros.backend.domain.service.IFormulaOneService;
import com.icarros.backend.domain.service.IRaceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RaceServiceJsonFilter implements IRaceService {

    private IFormulaOneService formulaOneService;

    public List<RaceApi> findRaceByRound(Integer round){
        FormulaOneApi formulaOneApi = formulaOneService.findFormulaOneApi();
        return formulaOneApi.getMrDataApi()
                .getRaceTable().getRaces()
                .stream().filter(raceApi -> raceApi.getRound().equals(round.toString()))
                .collect(Collectors.toList());
    }

    public List<RaceApi> findAllRaces(){
        FormulaOneApi formulaOneApi = formulaOneService.findFormulaOneApi();
        return formulaOneApi.getMrDataApi().getRaceTable().getRaces();
    }
}
