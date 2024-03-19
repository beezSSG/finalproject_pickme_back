package com.pickme.beeze.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.login.dao.LoginDao;
import com.pickme.beeze.login.dto.LoginDto;

@Service
@Transactional
public class LoginService {
    
	@Autowired
	private LoginDao dao;

	public int addCustomerInfo(LoginDto dto) {
		return dao.addCustomerInfo(dto);
	}
	public int addCeoInfo(LoginDto dto) {
		return dao.addCeoInfo(dto);
	}
	
	public int countCustomerInfo(String email) {
		return dao.countCustomerInfo(email);
	}
	public int countCeoInfo(String email) {
		return dao.countCeoInfo(email);
	}
	
	public LoginDto selectCustomerInfo(LoginDto dto) {
		return dao.selectCustomerInfo(dto);
	}
	public LoginDto selectCeoInfo(LoginDto dto) {
		return dao.selectCeoInfo(dto);
	}
	
	public LoginDto whoCustomer(String email) {
		return dao.whoCustomer(email);
	}
	public LoginDto whoCeo(String email) {
		return dao.whoCeo(email);
	}
	
	public LoginDto searchCustomerInfo(int id) {
		return dao.searchCustomerInfo(id);
	}
	public LoginDto searchCeoInfo(int id) {
		return dao.searchCeoInfo(id);
	}

}
