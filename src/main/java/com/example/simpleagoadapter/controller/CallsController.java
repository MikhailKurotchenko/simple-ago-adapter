package com.example.simpleagoadapter.controller;


import com.example.simpleagoadapter.entities.Call;
import com.example.simpleagoadapter.service.mapper.TypeConverter;
import example.ago.simple.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calls")
@RequiredArgsConstructor
public class CallsController {
    private final AgoService agoService;

    @PostMapping
    public void startCall(@RequestBody StartCallRequest request) throws DebtCallFault_Exception {
        agoService.startCall(request);
    }

    @PutMapping
    public BaseAGOResponse updateDebt(@RequestBody UpdateDebtRequest request) throws DebtCallFault_Exception {
        return agoService.updateDebt(request);
    }

    @GetMapping("/{id}")
    public GetStatusResponse getStatus(@PathVariable long id) throws DebtCallFault_Exception {
        GetStatusRequest request = new GetStatusRequest();
        request.setId(id);
        return agoService.getStatus(request);
    }

    @PostMapping("/{id}")
    public BaseAGOResponse stopCall(@RequestBody StopCallRequest request, @PathVariable long id) throws DebtCallFault_Exception {
        return agoService.stopCall(request);
    }
}
