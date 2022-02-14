package com.icarros.backend.domain.service.impl;

import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.application.dto.api.RaceApi;
import com.icarros.backend.application.dto.api.RaceTableApi;
import com.icarros.backend.domain.service.IFormulaOneService;
import com.icarros.backend.domain.service.IRaceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RaceServiceImpl implements IRaceService {

    private IFormulaOneService formulaOneService;

    @Override
    public RaceTableApi listRaceTable() {
        FormulaOneApi api = formulaOneService.findFormulaOneApi();
        return api.getMrDataApi().getRaceTable();
    }

    @Override
    public List<RaceApi> findRaceBySeason(String season) {
        FormulaOneApi formulaOneApi = formulaOneService.findFormulaOneApi();
        return formulaOneApi.getMrDataApi()
                .getRaceTable().getRaces()
                .stream().filter(raceApi -> raceApi.getSeason().equals(season))
                .collect(Collectors.toList());
    }
}
