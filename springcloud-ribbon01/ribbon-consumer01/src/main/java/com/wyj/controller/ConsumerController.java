package com.wyj.controller;

import com.wyj.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // Eureka客户端，可以获取到服务实例信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/findById/{id}")
    @ResponseBody
    public User findById(@PathVariable int id) {
        String serviceId = "eureka-provider";
        String baseUrl = "http://" + serviceId + "/findById/";
        User user = restTemplate.getForObject(baseUrl + id, User.class);
        return user;
    }

}
