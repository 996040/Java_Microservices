package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {
	
	@RequestMapping("//")
	public String Hello() {
		return "<h2> Welcome to the Coupon Services</h2>";
	}

}
