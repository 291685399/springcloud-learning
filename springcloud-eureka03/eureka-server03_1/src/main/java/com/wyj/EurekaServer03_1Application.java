package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer03_1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer03_1Application.class, args);
    }

}
