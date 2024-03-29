package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.example"})
@OpenAPIDefinition
public class SpringBootCouponServiceApplication  {

	public static void main(String[] args) {
		System.out.println("Rohit");
		SpringApplication.run(SpringBootCouponServiceApplication.class, args);
		System.out.println("Virat");
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}


}
