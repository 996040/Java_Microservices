package com.zensar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
@OpenAPIDefinition
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
