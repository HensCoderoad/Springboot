package com.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
@MapperScan(value = "com.spring.boot.mapper")
public class TransApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransApplication.class, args);
    }

}
