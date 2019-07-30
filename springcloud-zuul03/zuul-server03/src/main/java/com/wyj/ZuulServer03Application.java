package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZuulServer03Application {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer03Application.class, args);
    }

}
