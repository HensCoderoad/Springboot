package com.spring.boot.demo.controller;

import com.spring.boot.demo.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * @author : Hens
 * @date : 2019/9/19 20:25
 */
@RestController
public class LoginController {
    @Autowired
    private JavaMailSender javaMailSender;

    private Map<String, String> map = new HashMap<>();

    @CrossOrigin
    @PostMapping("login")
    public String login(@RequestBody LoginUser loginUser, HttpServletRequest request) throws ServletException, IOException {
        String s = map.get(loginUser.getUsername());
        if(!loginUser.getCode().equals(s)){
            return "false";
        }
        String to = "15915106210@163.com";
        if(loginUser.getUsername().equals(to)){
            request.getSession().setAttribute("user",loginUser);
            return "true";
        }
        return "false";
    }

    @CrossOrigin
    @GetMapping("icode/{username}")
    public String codeLogin(@PathVariable String username) throws MessagingException {
        System.out.println("------这是icode------");
        System.out.println(username);
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String substring = s.substring(0, 4);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setSubject("尚马教育");
        mimeMessageHelper.setText("您的验证码为"+substring+"，请妥善保管！");
        mimeMessageHelper.setFrom("15915106210@163.com");
        mimeMessageHelper.setTo(username);
        javaMailSender.send(mimeMessage);
        map.put(username, substring);
        return substring;
    }
}
