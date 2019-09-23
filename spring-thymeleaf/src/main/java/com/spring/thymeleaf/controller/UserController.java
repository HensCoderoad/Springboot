package com.spring.thymeleaf.controller;

import com.spring.thymeleaf.entity.User;
import com.spring.thymeleaf.service.UserServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/23 9:30
 */
@RestController
public class UserController {
    @Autowired
    private UserServcie userServcie;
    @GetMapping("list")
    public ModelAndView list(){
        List<User> list = userServcie.list();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",list);
        mv.setViewName("main");
        return mv;
    }
}
