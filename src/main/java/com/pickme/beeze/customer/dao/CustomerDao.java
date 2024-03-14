package com.pickme.beeze.customer.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustomerDao {
	
	// 장바구니 담기
	int getProductId(String productName);
	int getsProductId(int productId);
	int getCustomerId(String email);
	int cartinsert(int sProductId,int customerId);
	
	// 주문하기
	int order(int id);

}
