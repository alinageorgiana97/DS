package com.example.tema1;

import com.example.tema1.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.tema1.mapper"})

public class Tema1Application {
	public static void main(String []args){
		SpringApplication.run(Tema1Application.class, args);
	}

}
