package com.pickme.beeze.login.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.login.dto.LoginDto;
import com.pickme.beeze.login.service.LoginService;

@RestController
@RequestMapping("api/v1/user/*")
public class LoginController {

	@Autowired
	private LoginService service;
     
	/* TODO 통합 로그인 기능 */
	// 고객 회원가입
	@PostMapping("/regiCustomer")
	public int addCustomer(LoginDto dto) {
		System.out.println("LoginController regiCustomer " + new Date());
		
		System.out.println(dto.toString());
		
		return service.addCustomerInfo(dto); // 0: 회원가입실패 / 1: 회원가입성공
	}
	// 점주 회원가입
	@PostMapping("/regiCeo")
	public int regiCeo(LoginDto dto) {
		System.out.println("LoginController regiCeo " + new Date());
		
		return service.addCeoInfo(dto);	// 0: 회원가입실패 / 1: 회원가입성공
	}
	
	// 고객 및 점주 로그인
	@PostMapping("/login")
	public LoginDto login(LoginDto dto) {
		System.out.println("LoginController login " + new Date());
		
		// 확인작업
		service.whoCustomer(dto);
		
		if (dto.getRdate() != null || !dto.getRdate().equals("")) {	// 고객 로그인
			service.selectCustomerInfo(dto);
		} else {	// 점주 로그인
			service.selectCeoInfo(dto);
		}
		
		return dto;
	}
	// 관리자 로그인


	/* TODO 토근 적용 로그인 */
}
