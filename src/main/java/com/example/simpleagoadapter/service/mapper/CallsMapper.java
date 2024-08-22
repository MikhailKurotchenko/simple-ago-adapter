package com.example.simpleagoadapter.service.mapper;

import com.example.simpleagoadapter.entities.Call;
import example.ago.simple.StartCallRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CallsMapper {

    @Mapping(target = "asrClientId", expression = "java(request.getASRClientId())")
    Call startCallToCall(StartCallRequest request);
}
