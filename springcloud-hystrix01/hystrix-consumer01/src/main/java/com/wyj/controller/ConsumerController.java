package com.wyj.controller;

import com.wyj.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConsumerController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable int id) {
        String user = userDao.findById(id);
        return user;
    }

}
