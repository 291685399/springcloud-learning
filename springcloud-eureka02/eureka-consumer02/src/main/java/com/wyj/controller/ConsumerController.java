package com.wyj.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.wyj.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        // 根据服务名称，获取服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-provider");
        // 因为只有一个UserService,因此我们直接get(0)获取
        ServiceInstance instance = instances.get(0);
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort();
        System.out.println("baseUrl=" + baseUrl);
        User user = restTemplate.getForObject(baseUrl + "/findById/" + id, User.class);
//        User user = restTemplate.getForObject("http://127.0.0.1:8081/findById", User.class);
        return user;
    }

}
