package com.example.currierbrother;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@MapperScan(value = "com.example.currierbrother.mapper")
@SpringBootApplication
public class CurrierbrotherApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrierbrotherApplication.class, args);
	}
}
