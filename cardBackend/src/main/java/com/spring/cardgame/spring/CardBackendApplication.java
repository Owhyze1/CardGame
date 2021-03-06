package com.spring.cardgame.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.spring.cardgame.controller", "com.spring.cardgame.repository"})
public class CardBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardBackendApplication.class, args);
	}

}
