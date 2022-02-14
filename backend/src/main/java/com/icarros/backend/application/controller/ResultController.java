package com.icarros.backend.application.controller;


import com.icarros.backend.application.dto.api.ResultApi;
import com.icarros.backend.application.dto.api.ResultsApi;
import com.icarros.backend.domain.service.IResultService;
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
@RequestMapping(path = "/api/v1/formula1/result")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ResultController {

    private IResultService resultService;

    @ApiOperation(value = "list all results")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = ResultsApi.class)
    })
    @GetMapping
    public ResponseEntity<ResultsApi> listAllResults(){
        List<ResultApi> resultApiList = resultService.listAllResults();
        ResultsApi resultsApi = new ResultsApi(resultApiList);
        return ResponseEntity.ok().body(resultsApi);
    }
}
