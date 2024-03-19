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

	/* 회원가입 */
	public int addCustomerInfo(LoginDto dto) {
		return dao.addCustomerInfo(dto);
	}
	public int addCeoInfo(LoginDto dto) {
		return dao.addCeoInfo(dto);
	}
	
	/* 이메일(id) 중복확인 */
	public int countCustomerInfo(String email) {
		return dao.countCustomerInfo(email);
	}
	public int countCeoInfo(String email) {
		return dao.countCeoInfo(email);
	}
	
	/* 로그인전 정보확인 */
	public LoginDto whoCustomer(String email) {
		return dao.whoCustomer(email);
	}
	public LoginDto whoCeo(String email) {
		return dao.whoCeo(email);
	}
	
	/* 로그인 */
	public LoginDto selectCustomerInfo(LoginDto dto) {
		return dao.selectCustomerInfo(dto);
	}
	public LoginDto selectCeoInfo(LoginDto dto) {
		return dao.selectCeoInfo(dto);
	}
	
	/* 아이디/비밀번호 찾기 */
	public String findEmail(LoginDto dto) {
		String email = dao.findCustomerEmail(dto);
		if (email == null || email.equals("")) {
			email = dao.findCeoEmail(dto);
		}
		return email;
	}
	
	/* 토큰값을 통한 회원확인 */
	public LoginDto searchCustomerInfo(int id) {
		return dao.searchCustomerInfo(id);
	}
	public LoginDto searchCeoInfo(int id) {
		return dao.searchCeoInfo(id);
	}

}
