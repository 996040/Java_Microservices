package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Coupon;
import com.example.demo.service.CouponService;

@RestController
@RequestMapping("/coupon-api")
public class CouponController1 {
	
	@Autowired
	private CouponService couponService;
	
	//http://localhost:8888/Coupon
	
	
//	@RequestMapping("/coupon/{couponId}")
	@GetMapping(value ="/coupon/{couponId}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
	public Coupon getCoupon(@PathVariable("couponId") int couponId) {
		return couponService.getCoupon(couponId);
	}
	
//	@RequestMapping("/coupons")
	@GetMapping("/coupons")
	public List<Coupon> getAllCoupons(){
		return couponService.getAllCoupons();
	}
	@PostMapping(value="/coupons",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public void insertCoupon(@RequestBody Coupon coupon) {
		couponService.insertCoupon(coupon);
	}
	@DeleteMapping("/coupons/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
	}
	
	@PutMapping(value= "/coupons/{couponId}",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public void updateCoupon(@PathVariable("couponId") int couponId,@RequestBody Coupon coupon) {
		couponService.updateCoupon(couponId, coupon);
		
	}
	

}
