package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Hens
 * @date : 2019/9/18 21:15
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        return "Hello SpringBoot!";
    }
}
