package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.entity")  // Ensure this is correct
@EnableJpaRepositories(basePackages = "com.example.repo") // Ensure this is correct for the repo
@ComponentScan("com.example.controller")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
