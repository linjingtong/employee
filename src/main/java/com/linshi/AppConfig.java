package com.linshi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan("com.linshi.mapper")
@PropertySource("classpath:application.properties")
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class,args);
    }
}
