package com.example.currierbrother;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;


@MapperScan(value = "com.example.currierbrother.mapper")
@SpringBootApplication
@ServletComponentScan
public class CurrierbrotherApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){

        return application.sources(CurrierbrotherApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(CurrierbrotherApplication.class, args);
    }

}