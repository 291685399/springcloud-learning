package com.wyj.controller;

import com.wyj.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/findById")
    @ResponseBody
    public User findById() {
        User user = restTemplate.getForObject("http://127.0.0.1:8081/findById", User.class);
        return user;
    }

}
