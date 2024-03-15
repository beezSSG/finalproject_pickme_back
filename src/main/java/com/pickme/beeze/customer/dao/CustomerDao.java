package com.pickme.beeze.customer.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.customer.dto.CartDto;

@Mapper
@Repository
public interface CustomerDao {
	
	// 장바구니 담기
	int getsProductId(String productName,int storeId);
	int getCustomerId(String email);
	int cartinsert(CartDto dto);
	
	// 주문하기
	int order(int id);

}
