package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer>{
	
//	List<Coupon> getByCouponExpiry(String couponExpiry);
	
	@Query(value = "select * from coupon where coupon_expiry=:expiry",nativeQuery=true)
	List<Coupon> test(@Param("expiry")String couponExpiry);
	
//	List<Coupon> findByCouponExpiryAndCouponCode(String couponExpiry,int code);
	@Query("from Coupon s where s.couponExpiry=:expiry and s.couponCode=:code")
	List<Coupon> test1(@Param("expiry")String couponExpiry,@Param("code")int code);

}
