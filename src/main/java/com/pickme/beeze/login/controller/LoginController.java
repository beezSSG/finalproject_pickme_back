package com.pickme.beeze.login.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pickme.beeze.login.dto.LoginDto;
import com.pickme.beeze.login.dto.TokenDto;
import com.pickme.beeze.login.dto.UserDto;
import com.pickme.beeze.login.service.LoginService;
import com.pickme.beeze.util.NaverCloud;

import jakarta.servlet.http.HttpServletRequest;

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

	
	// OCR
	@PostMapping("/ocr")
	public String ocr(@RequestParam("uploadfile")MultipartFile uploadfile,
							HttpServletRequest re) throws Exception {
		System.out.println("NaverCloudController ocr " + new Date());
		
		String uploadPath = re.getServletContext().getRealPath("/upload");
		
		// 파일명을 취득
		String filename = uploadfile.getOriginalFilename();
		String filepath = uploadPath + File.separator + filename;	// uploadPath + / + filename
		
		System.out.println(filepath);
		
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		os.write(uploadfile.getBytes());
		os.close();
		
		// Naver cloud
		NaverCloud nc = new NaverCloud();
		String response = nc.OcrProc(filepath);
		return response;
	}
	
	
	/* TODO 토근 적용 로그인 */
}
