package com.zensar.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zensar.exceptionalHandling.CouponNotFound;

@ControllerAdvice
public class CouponExceptionController {
	@ExceptionHandler(value = CouponNotFound.class)
	public ResponseEntity<Object> exception(CouponNotFound exception){
		return new ResponseEntity<>("Coupon Not found",HttpStatus.NOT_FOUND);
	}

}
