package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Hens
 * @date : 2019/9/18 21:34
 */
@RestController
@RequestMapping("/api")
public class ExceptionController {

    @GetMapping("/illegalArgumentException")
    public void throwException(){
        throw new IllegalArgumentException();
    }
    @GetMapping("/resourceNotFoundException")
    public void throwException2(){
        throw new ResourceNotFoundException();
    }
}
