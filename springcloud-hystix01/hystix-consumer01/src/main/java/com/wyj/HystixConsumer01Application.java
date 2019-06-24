package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HystixConsumer01Application {

    public static void main(String[] args) {
        SpringApplication.run(HystixConsumer01Application.class, args);
    }

}
