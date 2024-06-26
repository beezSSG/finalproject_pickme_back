package com.pickme.beeze.manager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.customer.dao.CustomerDao;
import com.pickme.beeze.login.dto.CustomerDto;
import com.pickme.beeze.manager.dto.CouponDto;

@Mapper
@Repository
public interface CouponDao {

	// 쿠폰 생성
	int couponcreate(CouponDto dto);
	int countuser(CustomerDto dto);
	// 쿠폰 삭제
	int coupondelete(int couponNumber);
}
