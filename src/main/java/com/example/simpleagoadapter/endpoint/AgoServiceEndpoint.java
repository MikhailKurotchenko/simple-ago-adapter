package com.example.simpleagoadapter.endpoint;

import com.example.simpleagoadapter.service.AgoService;
import example.ago.simple.*;
import jakarta.jws.WebService;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.function.ThrowingSupplier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;


@RequiredArgsConstructor
@Component
public class AgoServiceEndpoint implements example.ago.simple.AgoService {
    private final AgoService agoService;
    private static final Logger log = LoggerFactory.getLogger(AgoServiceEndpoint.class);
//    private static final String NAMESPACE_URI = "http://simple.ago.example/";
//    private final ObjectFactory factory = new ObjectFactory();

//    @ResponsePayload
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StartCallRequest")
//    public JAXBElement<BaseAGOResponse> startCall(@RequestPayload  JAXBElement<StartCallRequest> request) {
//        StartCallRequest request1 = request.getValue();
//        BaseAGOResponse response = agoService.startCall(request1);
//        return factory.createStartCallResponse(response);
//    }
//
//
//    @ResponsePayload
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StopCallRequest")
//    public JAXBElement<BaseAGOResponse> stopCall(@RequestPayload JAXBElement<StopCallRequest> request) {
//        StopCallRequest request1 = request.getValue();
//        BaseAGOResponse response = agoService.stopCall(request1);
//        return factory.createStopCallResponse(response);
//    }
//
//    @ResponsePayload
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateDebtRequest")
//    public JAXBElement<BaseAGOResponse> updateCall(@RequestPayload JAXBElement<UpdateDebtRequest> request) {
//        UpdateDebtRequest request1 = request.getValue();
//        BaseAGOResponse response = agoService.updateCall(request1);
//        return factory.createUpdateDebtResponse(response);
//    }
//
//

//
//
//    @ResponsePayload
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetStatusRequest")
//    public JAXBElement<GetStatusResponse> getStatus(@RequestPayload JAXBElement<GetStatusRequest> request) throws DatatypeConfigurationException {
//        GetStatusRequest request1 = request.getValue();
//        GetStatusResponse response = agoService.getStatus(request1);
//        return factory.createGetStatusResponse(response);
//    }






    @Override
    public BaseAGOResponse closeSeason(CloseSeasonRequest request) {
        return null;
    }

    @Override
    public BaseAGOResponse startCall(StartCallRequest request) throws DebtCallFault_Exception {
        return agoService.startCall(request);
    }

    @Override
    public GetStatusResponse getStatus(GetStatusRequest request) throws DebtCallFault_Exception {
        try {
            return agoService.getStatus(request);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseAGOResponse stopCall(StopCallRequest request) throws DebtCallFault_Exception {
        return agoService.stopCall(request);
    }

    @Override
    public BaseAGOResponse updateDebt(UpdateDebtRequest request) throws DebtCallFault_Exception {
        return agoService.updateCall(request);
    }


}
