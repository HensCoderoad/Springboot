package com.spring.boot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Hens
 * @date : 2019/9/20 12:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mail {

    private String to;

    private String subject;

    private String context;

    private MultipartFile file;
}
