package com.example.demo.dto;

public class CouponDto {
	
	private int couponId;
	private String couponExpiry;
	private int couponCode;
	public CouponDto() {
		super();
	}
	public CouponDto(int couponId, String couponExpiry, int couponCode) {
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
		return "CouponDto [couponId=" + couponId + ", couponExpiry=" + couponExpiry + ", couponCode=" + couponCode
				+ "]";
	}
	
	

}
