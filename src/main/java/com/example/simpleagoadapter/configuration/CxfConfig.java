package com.example.simpleagoadapter.configuration;

import com.example.simpleagoadapter.configuration.factory.CxfServiceFactory;
import example.ago.simple.AgoService;
import example.ago.simple.AgoService_Service;
import jakarta.xml.ws.Endpoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CxfConfig {
    private final CxfServiceFactory factory;

    @Bean
    public Endpoint agoService(AgoService endpoint) {
        return factory.create(endpoint, new AgoService_Service(),
                "/AgoService", true);
    }
}
