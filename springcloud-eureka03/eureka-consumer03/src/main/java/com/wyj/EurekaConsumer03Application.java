package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumer03Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer03Application.class, args);
    }

}
