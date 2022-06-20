package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
public class SpringBootProductServiceApplication {

	public static void main(String[] args) {
		System.out.println("Welcome");
		SpringApplication.run(SpringBootProductServiceApplication.class, args);
		System.out.println("Started...");
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
