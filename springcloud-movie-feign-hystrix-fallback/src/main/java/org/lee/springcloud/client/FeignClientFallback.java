package org.lee.springcloud.client;

import org.lee.springcloud.entity.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @Override
    public User find(Map<String, Object> params) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }
}
