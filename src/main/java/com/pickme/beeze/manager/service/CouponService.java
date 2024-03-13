package com.pickme.beeze.manager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.manager.dao.CouponDao;
import com.pickme.beeze.manager.dto.CouponDto;

@Service
@Transactional
public class CouponService {
	
	@Autowired
	CouponDao dao;
	
	// 쿠폰 생성
	public boolean couponcreate(CouponDto dto) {
		
		 int count = 0;
		 for(int i = 1; i < 3; i++) {
			 dto.setUserId(i);
			 count = dao.couponcreate(dto);
		 }
		 
		return count>0?true:false;
	}
	// 쿠폰 삭제
	public boolean coupondelete(int couponNubmer) {
		int count = dao.coupondelete(couponNubmer);
		return count>0?true:false;
	}
}
