package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZuulServer02Application {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer02Application.class, args);
    }

}
