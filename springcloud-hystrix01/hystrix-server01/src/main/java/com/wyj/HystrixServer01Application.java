package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HystrixServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixServer01Application.class, args);
    }

}
