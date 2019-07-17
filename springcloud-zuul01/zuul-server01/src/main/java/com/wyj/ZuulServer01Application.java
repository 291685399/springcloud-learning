package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZuulServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer01Application.class, args);
    }

}
