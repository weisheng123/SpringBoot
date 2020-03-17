package com.albert.consumer.client;

import com.albert.consumer.po.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientImpl implements UserFeignClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setName("出现异常");
        return user;
    }
}
