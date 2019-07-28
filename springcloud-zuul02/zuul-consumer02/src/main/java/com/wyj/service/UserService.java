package com.wyj.service;

import com.wyj.client.UserFeignClient;
import com.wyj.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyj
 * @create 2019-06-30 0:20
 */
@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findById(int id) {
        User user = userFeignClient.findById(id);
        return user;
    }

}
