package com.example.simpleagoadapter.service.mapper;

import com.example.simpleagoadapter.entities.Call;
import com.example.simpleagoadapter.entities.Status;
import example.ago.simple.StartCallRequest;
import org.springframework.stereotype.Component;

@Component
public class TypeConverter {
    public static Call fromStartCall(StartCallRequest request) {
        Call call = new Call();
        call.setAccount(request.getAccount());
        call.setDebt(request.getDebt());
        call.setReason(request.getReason());
        call.setMsisdn(request.getMsisdn());
        call.setJuridical(request.getJuridical().toString());
        call.setPaymentDate(request.getPaymentDate());
        call.setTerminationDate(request.getTerminationDate());
        call.setAppPkId(request.getAppPkId());
        call.setAsrClientId(request.getASRClientId());
        call.setNotificationType(request.getNotificationType().toString());
        call.setStatus(Status.IN_PROGRESS);
        return call;
    }
}
