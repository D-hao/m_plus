package com.dh.m_plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class MPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MPlusApplication.class, args);
    }

}
