package com.rick.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer1 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer1.class, args);
    }
}
