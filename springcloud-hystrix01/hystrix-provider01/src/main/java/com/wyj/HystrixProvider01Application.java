package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HystrixProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixProvider01Application.class, args);
    }

}
