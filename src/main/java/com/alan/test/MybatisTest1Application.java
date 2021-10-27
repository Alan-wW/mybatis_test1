package com.alan.test;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.alan.test.mapper")
public class MybatisTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisTest1Application.class, args);
    }

}
