package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZuulProvider02Application {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProvider02Application.class, args);
    }

}
