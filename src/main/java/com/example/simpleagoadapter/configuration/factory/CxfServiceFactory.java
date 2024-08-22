package com.example.simpleagoadapter.configuration.factory;

import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.Service;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class CxfServiceFactory {
    private final Bus bus;

    public Endpoint create(Object endpoint, Service service, String contextPath, Boolean allowNonMatchingToDefaultSoapAction) {
        EndpointImpl endpointImpl = new EndpointImpl(bus, endpoint);
        if (service != null) {
            endpointImpl.setServiceName(service.getServiceName());
            endpointImpl.setWsdlLocation(service.getWSDLDocumentLocation().toString());

        }

        HashMap<String, Object> prop = new HashMap<>();
        prop.put("set-jaxb-validation-event-handler", "false");
        Optional.ofNullable(allowNonMatchingToDefaultSoapAction)
                .ifPresent(value -> prop.put("allowNonMatchingToDefaultSoapAction", value.toString()));
        endpointImpl.setProperties(prop);
        endpointImpl.publish(contextPath);
        return endpointImpl;
    }
}
