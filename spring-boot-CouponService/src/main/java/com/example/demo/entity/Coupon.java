package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {
	
	@Id
	private int couponId;
	private String couponExpiry;
	private int couponCode;
	public Coupon() {
		super();
	}
	public Coupon(int couponId, String couponExpiry, int couponCode) {
		super();
		this.couponId = couponId;
		this.couponExpiry = couponExpiry;
		this.couponCode = couponCode;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponExpiry() {
		return couponExpiry;
	}
	public void setCouponExpiry(String couponExpiry) {
		this.couponExpiry = couponExpiry;
	}
	public int getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponExpiry=" + couponExpiry + ", couponCode=" + couponCode + "]";
	}

	
	

}
