package com.bwie.bticonexplor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@MapperScan("")
@EnableFeignClients
public class BticonexplorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BticonexplorApplication.class, args);
	}

}
