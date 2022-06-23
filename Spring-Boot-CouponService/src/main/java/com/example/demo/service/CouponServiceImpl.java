package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
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

//	public CouponServiceImpl() {
//
//	}

	@Override
	public CouponDto getCoupon(int couponId) {
		Coupon coupon = couponRepository.findById(couponId).get();
//		CouponDto dto = mapToDto(coupon);
		
		return modelMapper.map(coupon,CouponDto.class);
		
//		return dto;

	}

	@Override
	public List<CouponDto> getAllCoupons(int pageNumber, int pageSize,String sortBy,Direction dir) {
//		List<Coupon>listOfCoupons = couponRepository.findAll();
		List<CouponDto> listOfCouponDto= new ArrayList<CouponDto>();
		
		Page<Coupon> findAll=couponRepository.findAll(PageRequest.of(pageNumber,pageSize,dir,sortBy));
		List<Coupon> content =findAll.getContent();
		for(Coupon coupon:content) {
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

	@Override
	public List<CouponDto> getByCouponExpiry(String couponExpiry) {
		List<CouponDto> couponDtos = new ArrayList<>();
		List<Coupon> coupons = couponRepository.test(couponExpiry);
		for(Coupon coupon:coupons)
			couponDtos.add(modelMapper.map(coupon,CouponDto.class));
		return couponDtos;
	}

	@Override
	public List<CouponDto> findByCouponExpiryAndCouponCode(String couponExpiry, int code) {
		List<CouponDto> couponDtos = new ArrayList<>();
		List<Coupon> coupons = couponRepository.test1(couponExpiry,code);
		for(Coupon coupon:coupons)
			couponDtos.add(modelMapper.map(coupon,CouponDto.class));
		return couponDtos;
		
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
