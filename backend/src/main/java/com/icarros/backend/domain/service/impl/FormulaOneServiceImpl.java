package com.icarros.backend.domain.service.impl;

import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.domain.service.IFormulaOneService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FormulaOneServiceImpl implements IFormulaOneService {

    private final String url;
    private final RestTemplate restTemplate;

    public FormulaOneServiceImpl(){
        this.restTemplate = new RestTemplate();
        this.url = "https://ergast.com/api/f1/2017/last/results.json";
    }


    @Override
    public FormulaOneApi findFormulaOneApi() {
        return this.restTemplate.getForObject(this.url, FormulaOneApi.class);
    }
}
