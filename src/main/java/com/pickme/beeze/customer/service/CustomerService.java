package com.pickme.beeze.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.customer.dao.CustomerDao;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerDao dao;
	
	// 장바구니 담기
	public int getProductId(String productName) {
		return dao.getProductId(productName);
	}
	public int getsProductId(int productId) {
		return dao.getsProductId(productId);
	}
	public int getCustomerId(String email) {
		return dao.getCustomerId(email);
	}
	public boolean cartinsert(int sProductId,int customerId) {
		int count = dao.cartinsert(sProductId, customerId);
		return count>0?true:false;
	}
	
	// 주문하기
	public boolean order(int id) {
		int count = dao.order(id);
		return count>0?true:false;
	}
}
