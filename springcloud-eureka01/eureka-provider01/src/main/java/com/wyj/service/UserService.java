package com.wyj.service;

import com.wyj.entity.po.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    public User findById(int id);

}
