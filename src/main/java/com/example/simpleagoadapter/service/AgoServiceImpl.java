package com.example.simpleagoadapter.service;

import com.example.simpleagoadapter.entities.Call;
import com.example.simpleagoadapter.entities.Status;
import com.example.simpleagoadapter.exceptions.CommandNotExistException;
import com.example.simpleagoadapter.repository.CallRepository;
import com.example.simpleagoadapter.service.mapper.CallsMapper;
import com.example.simpleagoadapter.service.mapper.TypeConverter;
import example.ago.simple.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.GregorianCalendar;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgoServiceImpl implements AgoService {

    private final CallRepository repository;
    private final CallsMapper mapper;
    @Override
    public BaseAGOResponse startCall(StartCallRequest request) {
        BaseAGOResponse response = new BaseAGOResponse();
//        Call call = TypeConverter.fromStartCall(request);
        Call call = mapper.startCallToCall(request);


        try {
            repository.save(call);
            response.setMessage("SUCCESS");
            response.setResultCode(0);
        } catch (Exception e) {
            response.setResultCode(-1);
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @Override
    public BaseAGOResponse stopCall(StopCallRequest request) {
        BaseAGOResponse response = new BaseAGOResponse();
        Long commandId = request.getId();
        Optional<Call> optional = repository.findById(commandId);
        if(optional.isEmpty()) {
//            response.setResultCode(-1);
//            response.setMessage("No such command in REIP");
            throw new CommandNotExistException(request.getId());
        } else {
            Call call = optional.get();
            call.setStatus(Status.CANCELLED);
            call.setReason(request.getReason());
            repository.save(call);
            response.setResultCode(0);
            response.setMessage("SUCCESS");
        }
        return response;
    }

    @Override
    public BaseAGOResponse updateCall(UpdateDebtRequest request) {
        BaseAGOResponse response = new BaseAGOResponse();
        Optional<Call> optional = repository.findById(request.getId());
        if (optional.isEmpty()) {
//            response.setResultCode(-1);
//            response.setMessage("No such command in REIP");
            throw new CommandNotExistException(request.getId());
        } else {
            Call call = optional.get();
            call.setDebt(request.getDebt());
            repository.save(call);
            response.setResultCode(0);
            response.setMessage("SUCCESS");
        }
        return response;
    }

    @Override
    public BaseAGOResponse closeSeason(CloseSeasonRequest request) {
        return null;
    }

    @Override
    public GetStatusResponse getStatus(GetStatusRequest request) {
        GetStatusResponse response = new GetStatusResponse();
        Optional<Call> optional = repository.findById(request.getId());
        if (optional.isEmpty()) {
            throw new CommandNotExistException(request.getId());
        } else {
            Call call = optional.get();
            example.ago.simple.Status status = new example.ago.simple.Status();
            status.setStatus(call.getStatus().toString());
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(System.currentTimeMillis());
            status.setCompleteDate(calendar);
            response.setStatus(status);
        }
        return response;
    }
}
