package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaRepositories
@SpringBootApplication
public class ChristinaHelloSpringBootApplication {
	 
	public static void main(String[] args) {
		SpringApplication.run(ChristinaHelloSpringBootApplication.class, args);
			
		System.out.println("Christina Spring Boot Application is running.");
	}
}
