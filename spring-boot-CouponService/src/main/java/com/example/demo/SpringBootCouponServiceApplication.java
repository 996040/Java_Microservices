package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.example"})
public class SpringBootCouponServiceApplication {

	public static void main(String[] args) {
		System.out.println("Rohit");
		SpringApplication.run(SpringBootCouponServiceApplication.class, args);
		System.out.println("Virat");
	}
	
	public void run(String... args) throws Exception{
		System.out.println("Yuvii");
	}

}
