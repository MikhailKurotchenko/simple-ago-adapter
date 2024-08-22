//package com.example.simpleagoadapter.configuration;
//
//
//
//
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.ws.config.annotation.EnableWs;
//import org.springframework.ws.transport.http.MessageDispatcherServlet;
//import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
//import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
//import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
//import org.springframework.xml.xsd.SimpleXsdSchema;
//
//
//
//@Configuration
//@EnableWs
//public class MyConfig {
//
//    @Bean
//    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(context);
//        servlet.setTransformWsdlLocations(true);
//        return new ServletRegistrationBean<>(servlet, "/services/*");
//    }
//
//
//
//    @Bean(name = "AgoService")
//    public Wsdl11Definition wsdl11Definition() {
//        SimpleWsdl11Definition simpleWsdl11Definition = new SimpleWsdl11Definition();
//        simpleWsdl11Definition.setWsdl(new ClassPathResource("AgoService.wsdl"));
//        return simpleWsdl11Definition;
//    }
//
//
//
////    @Bean
////    public SimpleXsdSchema xsdSchema() {
////        return new SimpleXsdSchema(new ClassPathResource("AgoService.xsd"));
////    }
////
////
////    @Bean(name = "AgoService")
////    public DefaultWsdl11Definition wsdl11Definition(SimpleXsdSchema simpleXsdSchema) {
////        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
////        definition.setSchema(simpleXsdSchema);
////        definition.setPortTypeName("AgoService");
////        definition.setLocationUri("/services");
////        definition.setTargetNamespace("http://simple.ago.example/");
////        return definition;
////    }
//
//
//}
