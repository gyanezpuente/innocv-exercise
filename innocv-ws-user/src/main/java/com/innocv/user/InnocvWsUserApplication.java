package com.innocv.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.innocv"})
public class InnocvWsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnocvWsUserApplication.class, args);
	}

}
