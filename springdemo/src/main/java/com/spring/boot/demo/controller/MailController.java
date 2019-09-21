package com.spring.boot.demo.controller;

import com.spring.boot.demo.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author : Hens
 * @date : 2019/9/20 9:42
 */
@RestController
public class MailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("mail")
    public void sendEmail(@RequestBody Mail mail) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(mail.getTo());
        mimeMessageHelper.setFrom("");
        mimeMessageHelper.setSubject(mail.getSubject());
        mimeMessageHelper.setText(mail.getContext());
        mimeMessageHelper.addAttachment(mail.getFile().getName(),mail.getFile());
        javaMailSender.send(mimeMessage);
    }
}
