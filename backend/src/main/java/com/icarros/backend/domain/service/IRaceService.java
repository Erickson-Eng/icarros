package com.icarros.backend.domain.service;

import com.icarros.backend.application.dto.api.RaceApi;
import com.icarros.backend.application.dto.api.RaceTableApi;

import java.util.List;

public interface IRaceService {

    RaceTableApi listRaceTable();

    List<RaceApi> findRaceBySeason(String season);
}
