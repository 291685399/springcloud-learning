package com.wyj.controller;

import com.netflix.discovery.converters.Auto;
import com.wyj.dao.UserDao;
import com.wyj.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CustomerController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/findById/{id}")
    @ResponseBody
    public User findById(@PathVariable int id) {
        User user = userDao.findById(id);
        return user;
    }

}
