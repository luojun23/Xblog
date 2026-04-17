package com.njtech.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.njtech.blog"})
@EnableAsync
@MapperScan("com.njtech.blog.mappers")
public class BlogJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogJavaApplication.class, args);
    }

}
