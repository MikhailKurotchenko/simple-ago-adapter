package com.example.simpleagoadapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SimpleAgoAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleAgoAdapterApplication.class, args);
        System.out.println("ТЕСТ");
    }

}
