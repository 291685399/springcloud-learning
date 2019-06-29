package com.wyj.dao;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@DefaultProperties(defaultFallback = "defaultFallback")
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    //开启线程隔离和服务降级，声明一个失败回滚处理函数queryUserByIdFallback，当queryUserById执行超时（默认是1000毫秒），就会执行fallback函数，返回错误提示。
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//触发熔断请求次数，默认是20次
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//熔断器关闭进入休眠时间，默认是5秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//触发熔断的失败请求最小占比，默认是50%
    })
    public String findById(int id) {
        if (id % 2 == 0) {
            throw new RuntimeException("");
        }
        long begin = System.currentTimeMillis();
        String url = "http://eureka-provider/findById/" + id;
        String user = restTemplate.getForObject(url, String.class);
        long end = System.currentTimeMillis();
        // 记录访问用时：
        logger.info("访问用时：{}", end - begin);
        return user;
    }

    public String findByIdFallback(int id) {
        return "查询用户信息超时";
    }

    public String defaultFallback() {//通用方法不用写参数，返回值一般写String
        return "网络异常";
    }
}
