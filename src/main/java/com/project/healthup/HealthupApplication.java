package com.project.healthup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HealthupApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthupApplication.class, args);
	}

}
