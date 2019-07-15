package com.wyj.client;

import com.wyj.entity.po.User;
import org.springframework.stereotype.Component;

/**
 * @author wyj
 * @create 2019-06-30 10:09
 */
@Component
public class UserFeignClientFallBack implements UserFeignClient {

    @Override
    public User findById(int id) {
        User user = new User();
        user.setName("未知用户");
        return user;
    }

}
