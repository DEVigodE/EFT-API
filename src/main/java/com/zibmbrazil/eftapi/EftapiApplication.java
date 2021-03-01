package com.zibmbrazil.eftapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EftapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EftapiApplication.class, args);
	}

}
