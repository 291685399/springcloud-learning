package com.wyj.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced//RestTemplate在请求时拥有客户端负载均衡的能力，这种方式发送的请求都会被ribbon拦截，ribbon从eureka注册中心获取服务列表，然后采用均衡策略进行访问
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
