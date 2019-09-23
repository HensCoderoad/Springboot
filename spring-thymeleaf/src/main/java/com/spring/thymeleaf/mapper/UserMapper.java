package com.spring.thymeleaf.mapper;

import com.spring.thymeleaf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/**
 * @author : Hens
 * @date : 2019/9/23 9:26
 */
@Repository
public class UserMapper {

    static List<User> list = new ArrayList<>();

    static {
        list.add(new User("li","1234"));
        list.add(new User("lai","4567"));
        list.add(new User("yang","4567"));
    }

    public List<User> list(){
        return list;
    }
}
