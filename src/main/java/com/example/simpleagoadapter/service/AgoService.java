package com.example.simpleagoadapter.service;

import example.ago.simple.*;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;


public interface AgoService {
    BaseAGOResponse startCall(StartCallRequest request);
    BaseAGOResponse stopCall(StopCallRequest request);
    BaseAGOResponse updateCall(UpdateDebtRequest request);
    BaseAGOResponse closeSeason(CloseSeasonRequest request);
    GetStatusResponse getStatus(GetStatusRequest request) throws DatatypeConfigurationException;

}
