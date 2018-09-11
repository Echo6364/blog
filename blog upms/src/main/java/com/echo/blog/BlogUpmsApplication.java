package com.echo.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.echo.blog.*.*.mapper")
@EnableEurekaClient
@SpringBootApplication
public class BlogUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogUpmsApplication.class, args);
    }
}
