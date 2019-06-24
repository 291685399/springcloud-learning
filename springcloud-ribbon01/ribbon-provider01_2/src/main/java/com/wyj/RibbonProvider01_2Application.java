package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RibbonProvider01_2Application {

    public static void main(String[] args) {
        SpringApplication.run(RibbonProvider01_2Application.class, args);
    }

}
