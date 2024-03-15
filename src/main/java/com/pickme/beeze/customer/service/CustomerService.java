package com.pickme.beeze.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.customer.dao.CustomerDao;
import com.pickme.beeze.customer.dto.CartDto;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerDao dao;
	
	// 장바구니 담기
	public int getsProductId(String productName, int storeId) {
		return dao.getsProductId(productName,storeId);
	}
	public int getCustomerId(String email) {
		return dao.getCustomerId(email);
	}
	public boolean cartinsert(CartDto dto) {
		int count = dao.cartinsert(dto);
		return count>0?true:false;
	}
	
	// 주문하기
	public boolean order(int id) {
		int count = dao.order(id);
		return count>0?true:false;
	}
}
