package com.pragmaticbitbucket.photoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@EnableConfigServer
@SpringBootApplication
public class PhotoappapiconfigserverApplication {

    @Autowired
    Environment environment;

    private String printPropertyValue;

    public static void main(String[] args) {
        SpringApplication.run(PhotoappapiconfigserverApplication.class, args);
    }

    @Bean
    public String printPropertyValue() {
        System.out.println("bootstrap Key store alias: " + environment.getProperty("encrypt.key-store.alias"));
        System.out.println("bootstrap key store password: " + environment.getProperty("encrypt.key-store.password"));
        System.out.println("bootstrap Key file has value: " + environment.getProperty("encrypt.key-store.location"));
        return "Just testing";
    }
}
