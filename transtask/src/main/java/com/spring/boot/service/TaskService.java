package com.spring.boot.service;

import com.spring.boot.entity.Count;
import com.spring.boot.mapper.CountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Hens
 * @date : 2019/9/24 10:37
 */
@Service
@Transactional
public class TaskService {
    @Autowired
    private CountMapper countMapper;
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    @Scheduled(cron = "0 1 * * * ?")
    public void sendEmail(){
        System.out.println("执行了");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo("877709291@qq.com");
        simpleMailMessage.setSubject("Hello");
        simpleMailMessage.setText("Hello Springboot Email");
        javaMailSender.send(simpleMailMessage);

    }

    public void transaction(Count count){
        countMapper.updateById(count);
        int i = 10 /0;
        count.setMoney(1000L);
        countMapper.updateById(count);
    }

    public Count get(Integer id){
        return countMapper.selectById(id);
    }
}
