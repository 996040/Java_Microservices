package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CouponDto;
import com.example.demo.entity.Coupon;

public interface CouponService {

	public CouponDto getCoupon(int couponId);

	public List<CouponDto> getAllCoupons(int pageNumber ,int pageSize);

	public CouponDto insertCoupon(CouponDto coupon);

	public void updateCoupon(int couponId, CouponDto coupon);

	public void deleteCoupon(int couponId);
	
	List<CouponDto> getByCouponExpiry(String couponExpiry);
	
	List<CouponDto> findByCouponExpiryAndCouponCode(String couponExpiry,int code);

}
