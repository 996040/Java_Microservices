package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProductServiceApplication {

	public static void main(String[] args) {
		System.out.println("Started...");
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("Starting...");
	}
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
}
