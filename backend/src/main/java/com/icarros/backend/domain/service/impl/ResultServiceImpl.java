package com.icarros.backend.domain.service.impl;

import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.application.dto.api.RaceApi;
import com.icarros.backend.application.dto.api.ResultApi;
import com.icarros.backend.domain.service.IFormulaOneService;
import com.icarros.backend.domain.service.IResultService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ResultServiceImpl implements IResultService {

    private IFormulaOneService formulaOneService;

    @Override
    public List<ResultApi> listAllResults() {
        FormulaOneApi api = formulaOneService.findFormulaOneApi();
        List<List<ResultApi>> result = api.getMrDataApi().getRaceTable().getRaces().stream()
                .map(RaceApi::getResultApiList).collect(Collectors.toList());

        return result.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
