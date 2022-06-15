package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Coupon;
import com.example.demo.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	public CouponServiceImpl() {

	}

	@Override
	public Coupon getCoupon(int couponId) {
		return couponRepository.findById(couponId).get();

	}

	@Override
	public List<Coupon> getAllCoupons() {
		return couponRepository.findAll();

	}

	@Override
	public void insertCoupon(Coupon coupon) {
		couponRepository.save(coupon);

	}

	@Override
	public void updateCoupon(int couponId, Coupon coupon) {
		couponRepository.save(coupon);

	}

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);

	}

}
