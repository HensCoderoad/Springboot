package com.spring.boot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Hens
 * @date : 2019/9/19 20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUser {

    private String username;

    private String code;

    private boolean rememberMe;

}
