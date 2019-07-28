package com.wyj.client;

import com.wyj.entity.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 这是一个接口，Feign会通过动态代理，帮我们生成实现类
 * <p>
 * `@FeignClient`，声明这是一个Feign客户端
 * <p>
 * 接口中的定义方法，完全采用SpringMVC的注解，Feign会根据注解帮我们生成URL，并访问获取结果
 *
 * @author wyj
 * @create 2019-06-30 0:17
 */
@FeignClient(value = "eureka-provider",fallback = UserFeignClientFallBack.class)
public interface UserFeignClient {

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id);

}
