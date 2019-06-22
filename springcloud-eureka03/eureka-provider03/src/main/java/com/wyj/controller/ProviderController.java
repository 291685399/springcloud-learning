package com.wyj.controller;

import com.wyj.entity.po.User;
import com.wyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProviderController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findById/{id}")
    @ResponseBody
    public User findById(@PathVariable int id) {
        User user = userService.findById(id);
        return user;
    }

}
