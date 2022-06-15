package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Coupon;

public interface CouponService {
	
	public Coupon getCoupon(int couponId);
	public List<Coupon> getAllCoupons();
	public void insertCoupon(Coupon coupon);
	public void updateCoupon(int couponId, Coupon coupon);
	public void deleteCoupon(int couponId);

}
