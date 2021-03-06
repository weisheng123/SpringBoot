package com.albert.userservice.service;

import com.albert.userservice.mapper.UserMapper;
import com.albert.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    
    public User queryById(Long id) {
//        try {
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this.userMapper.selectByPrimaryKey(id);
    }
}
