package com.spring.thymeleaf.service;

import com.spring.thymeleaf.entity.User;
import com.spring.thymeleaf.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/23 9:28
 */
@Service
public class UserServcie {
    @Autowired
    private UserMapper userMapper;

    public List<User> list(){
        return userMapper.list();
    }
}
