package com.zensar.secure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "this is the home page";
	}
	

	@GetMapping("/login")
	public String login() {
		return "this is the login page";
	}
	

	@GetMapping("/register")
	public String register() {
		return "this is the register page";
	}

}
