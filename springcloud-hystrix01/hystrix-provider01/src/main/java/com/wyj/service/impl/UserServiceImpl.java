package com.wyj.service.impl;

import com.wyj.dao.UserRepository;
import com.wyj.entity.po.User;
import com.wyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        return user;
    }

}
