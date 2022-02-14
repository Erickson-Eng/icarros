package com.icarros.backend.domain.service;

import com.icarros.backend.application.dto.api.ResultApi;

import java.util.List;

public interface IResultService {

    List<ResultApi> listAllResults();
}
