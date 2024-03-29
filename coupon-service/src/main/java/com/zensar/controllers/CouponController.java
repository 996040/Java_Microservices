package com.zensar.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Coupon;
import com.zensar.exceptionalHandling.CouponNotFound;
import com.zensar.services.CouponService;

@RestController
@RequestMapping("/coupons")
public class CouponController {
	
	private String instanceName;
	
//	private static Map<String,Coupon> couponRepo = new HashMap<>();

	@Autowired
	private CouponService couponService;

	@PostMapping("/")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponService.createCoupon(coupon);
	}

	// http://localhost:8080/coupons/MAX50 -> GET
	@GetMapping("/{couponCode}")
	public Coupon getCoupon(@PathVariable("couponCode") String couponCode) {
		System.out.println("Instance 1");
//		System.out.println("Instance 2");
		return couponService.getCoupon(couponCode);
	}
	
	@GetMapping("/allCoupons")
	public List<Coupon> getAllCoupons(){
		return couponService.getAllCoupons();
	}
	
	@DeleteMapping("/{couponCode}")
	public void delete (@PathVariable("couponCode") String couponCode) {
		couponService.deleteCoupon(couponCode);
	}
	
	
	
	
//	@PutMapping("/{couponCode}")
//	public ResponseEntity<Object> updateCoupon(@PathVariable("couponCode") String couponCode,
//			@RequestBody Coupon coupon){
//		if(!couponRepo.containsKey(couponCode))
//			throw new CouponNotFound();
//		couponRepo.remove(couponCode);
//		coupon.setCouponCode(couponCode);	
//		couponRepo.put(couponCode,coupon);
//		return new ResponseEntity<>("Coupon is Updated Successfully...",HttpStatus.OK);
//		
//	}
	

	

}
