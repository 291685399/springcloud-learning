package com.wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy//zuul中有大量的过滤器，而@EnabledZuulServer的功能单一
public class Zuul03Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul03Application.class, args);
    }

}
