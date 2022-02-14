package com.icarros.backend.domain.service.impl;

import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.application.dto.api.RaceApi;
import com.icarros.backend.domain.service.IFormulaOneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormulaOneService implements IFormulaOneService {

    private final String url;
    private final RestTemplate restTemplate;

    public FormulaOneService(){
        this.restTemplate = new RestTemplate();
        this.url = "https://ergast.com/api/f1/2017/last/results.json";
    }


    @Override
    public FormulaOneApi findFormulaOneApi() {
        return this.restTemplate.getForObject(this.url, FormulaOneApi.class);
    }
}
