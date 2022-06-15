package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {
	
	@Id
	private int couponId;
	private String couponName;
	private int couponCode;
	public Coupon() {
		super();
	}
	public Coupon(int couponId, String couponName, int couponCode) {
		super();
		this.couponId = couponId;
		this.couponName = couponName;
		this.couponCode = couponCode;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public int getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(int couponCode) {
		this.couponCode = couponCode;
	}
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponName=" + couponName + ", couponCode=" + couponCode + "]";
	}
	
	

}
