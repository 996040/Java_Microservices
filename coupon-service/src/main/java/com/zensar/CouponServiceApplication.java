package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CouponServiceApplication {

	public static void main(String[] args) {
		System.out.println("Started...");
		SpringApplication.run(CouponServiceApplication.class, args);
		System.out.println("Starting...");
	}
	

}
