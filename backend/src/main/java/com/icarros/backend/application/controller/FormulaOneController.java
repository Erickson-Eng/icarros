package com.icarros.backend.application.controller;


import com.icarros.backend.application.dto.api.FormulaOneApi;
import com.icarros.backend.domain.service.IFormulaOneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/v1/formula1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FormulaOneController {

    private IFormulaOneService formulaOneService;

    @GetMapping()
    public ResponseEntity<FormulaOneApi> getAllResponseForSeason(){
        FormulaOneApi formulaOneApi = formulaOneService.findFormulaOneApi();
        return ResponseEntity.ok().body(formulaOneApi);
    }
}
