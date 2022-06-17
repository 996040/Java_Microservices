package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CouponDto;
import com.example.demo.entity.Coupon;
import com.example.demo.service.CouponService;

@RestController
@RequestMapping(value = "/coupon-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CouponController1 {

	@Autowired
	private CouponService couponService;

	// http://localhost:8888/coupon-api/coupons

//	@RequestMapping("/coupon/{couponId}")
	@GetMapping(value = "/coupons/{couponId}")
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponId") int couponId) {
		return new ResponseEntity<CouponDto>(couponService.getCoupon(couponId), HttpStatus.OK);
	}

//	@RequestMapping("/coupons")
	@GetMapping("/coupons")
	public ResponseEntity<List<CouponDto>> getAllCoupons(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy",required=false, defaultValue = "couponExpiry")String sortBy,
			@RequestParam(value = "dir",required = false, defaultValue = "ASC")Direction dir){
		return new ResponseEntity<List<CouponDto>>(couponService.getAllCoupons(pageNumber,pageSize,sortBy,dir), HttpStatus.OK);
	}

	@PostMapping(value = "/coupons")
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto) {
		return new ResponseEntity<CouponDto>(couponService.insertCoupon(couponDto), HttpStatus.CREATED);

//		System.out.println("Hello");
	}

	@DeleteMapping("/coupons/{couponId}")
	public ResponseEntity<String> deleteCoupon(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
		return new ResponseEntity<String>("Coupon Deleted Successfully!!!", HttpStatus.OK);
	}

	@PutMapping(value = "/coupons/{couponId}")
	public ResponseEntity<String> updateCoupon(@PathVariable("couponId") int couponId,
			@RequestBody CouponDto couponDto) {
		couponService.updateCoupon(couponId, couponDto);
		return new ResponseEntity<String>("Coupon Updated Successfully!!!", HttpStatus.OK);

	}

	// http:localhost:8888/coupon-api/coupons/couponexpiry/Jan

	@GetMapping("/coupons/couponexpiry/{couponExpiry}")
	public ResponseEntity<List<CouponDto>> getByCouponExpiry(@PathVariable("couponExpiry") String couponExpiry) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponExpiry(couponExpiry), HttpStatus.OK);
	}

	@GetMapping("/coupons/{couponExpiry}/{couponCode}")
	public ResponseEntity<List<CouponDto>> findByCouponExpiryAndCouponCode(
			@PathVariable("couponExpiry") String couponExpiry, @PathVariable("couponCode") int code) {
		return new ResponseEntity<List<CouponDto>>(couponService.findByCouponExpiryAndCouponCode(couponExpiry, code),
				HttpStatus.OK);
	}

}
