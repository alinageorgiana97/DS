package com.example.tema1;

import com.example.tema1.entity.Activity;
import com.example.tema1.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Tema1Application {

 private static ConsumerService consumerService ;

	public Tema1Application(ConsumerService consumerService) {
		this.consumerService=consumerService;
	}

	@Autowired





	public static void main(String []args) throws Exception {
		SpringApplication.run(Tema1Application.class, args);
		consumerService.recieve();
		//consumerService.isAnomalus();

	}

}
