package com.spring.boot.controller;

import com.spring.boot.entity.Count;
import com.spring.boot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Hens
 * @date : 2019/9/24 10:37
 */
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public String update(@RequestBody Count count){
        taskService.transaction(count);
        return "success";
    }

    @GetMapping
    public Count get(Integer id){
        return taskService.get(id);
    }
}
