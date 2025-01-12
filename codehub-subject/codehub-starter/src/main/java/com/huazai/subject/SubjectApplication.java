package com.huazai.subject;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *刷题微服务启动类
 */

@MapperScan("com.huazai.**.mapper")
@ComponentScan("com.huazai")
@SpringBootApplication
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class, args);
    }
}
