package com.pickme.beeze.manager.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.login.dto.CustomerDto;
import com.pickme.beeze.manager.dto.CouponDto;
import com.pickme.beeze.manager.service.CouponService;

@RestController
@RequestMapping("/api/v1/manager/*")
public class CouponController {

	@Autowired
	CouponService service;
	
	// 쿠폰 생성
	@GetMapping("/couponcreate")
	public String couponcreate(CouponDto dto,CustomerDto cusdto) {
		
		System.out.println("CouponController couponcreate " + new Date());
		
		int count = service.countuser(cusdto);
		
		boolean isS = service.couponcreate(dto,count);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	// 쿠폰 삭제
	@GetMapping("/coupondelete")
	public String coupondelete(int couponNumber) {
		
		System.out.println("CouponController coupondelete " + new Date());
		
		boolean isS = service.coupondelete(couponNumber);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
