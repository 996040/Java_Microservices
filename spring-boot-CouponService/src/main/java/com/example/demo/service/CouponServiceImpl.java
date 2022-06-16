package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CouponDto;
import com.example.demo.entity.Coupon;
import com.example.demo.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public CouponServiceImpl() {

	}

	@Override
	public CouponDto getCoupon(int couponId) {
		Coupon coupon = couponRepository.findById(couponId).get();
//		CouponDto dto = mapToDto(coupon);
		
		return modelMapper.map(coupon,CouponDto.class);
		
//		return dto;

	}

	@Override
	public List<CouponDto> getAllCoupons() {
		List<Coupon>listOfCoupons = couponRepository.findAll();
		List<CouponDto> listOfCouponDto= new ArrayList<CouponDto>();
		
		for(Coupon coupon:listOfCoupons) {
//			listOfCouponDto.add(mapToDto(coupon));
			listOfCouponDto.add(modelMapper.map(coupon,CouponDto.class));
		}
		return listOfCouponDto;

	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {
//		Coupon coupon = mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto,Coupon.class);
		Coupon insertedCoupon =couponRepository.save(coupon);
//		CouponDto mapToDto =mapToDto(insertedCoupon);
		return modelMapper.map(insertedCoupon,CouponDto.class);
	
//		return mapToDto;

	}

	@Override
	public void updateCoupon(int couponId, CouponDto couponDto) {
//		Coupon coupon = mapToEntity(couponDto);
		Coupon coupon = modelMapper.map(couponDto,Coupon.class);
		couponRepository.save(coupon);

	}

	@Override
	public void deleteCoupon(int couponId) {
		couponRepository.deleteById(couponId);

	}
	
/*	
	public CouponDto mapToDto(Coupon coupon) {
		CouponDto dto= new CouponDto();
		dto.setCouponId(coupon.getCouponId());
		dto.setCouponExpiry(coupon.getCouponExpiry());
		dto.setCouponCode(coupon.getCouponCode());
		return dto;
	}
	
	public Coupon mapToEntity(CouponDto couponDto) {
		Coupon coupon = new Coupon();
		coupon.setCouponId(couponDto.getCouponId());
		coupon.setCouponExpiry(couponDto.getCouponExpiry());
		coupon.setCouponCode(couponDto.getCouponCode());
		
		return coupon;
	}
	*/

}
