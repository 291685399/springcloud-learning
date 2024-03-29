package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignProvider02Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignProvider02Application.class, args);
    }

}
