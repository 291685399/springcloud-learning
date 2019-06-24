package com.wyj.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyj.entity.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    //声明一个失败回滚处理函数queryUserByIdFallback，当queryUserById执行超时（默认是1000毫秒），就会执行fallback函数，返回错误提示。
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(int id) {
        long begin = System.currentTimeMillis();
        String url = "http://eureka-provider/findById/" + id;
        User user = restTemplate.getForObject(url, User.class);
        long end = System.currentTimeMillis();
        // 记录访问用时：
        logger.info("访问用时：{}", end - begin);
        return user;
    }

    public User findByIdFallback(int id) {
        User user = new User();
        user.setId(id);
        user.setName("用户信息查询出现异常！");
        return user;
    }
}
