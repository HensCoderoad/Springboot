package com.spring.thymeleaf.entity;

import lombok.*;

/**
 * @author : Hens
 * @date : 2019/9/23 9:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {

    private String username;

    private String password;

}
