package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HystrixServer02Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixServer02Application.class, args);
    }

}
