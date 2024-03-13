package com.pickme.beeze.mypage.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.mypage.dto.MypageSaveDto;
import com.pickme.beeze.mypage.service.MypageService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/mypage/*")
public class MypageController {
	
	@Autowired
	MypageService service;
	
	// TODO 찜
	// 찜 생성
	@PostMapping("/addSave")
	public int addSave(MypageSaveDto dto) {	// 유저 토큰이 들어와야함
		System.out.println("MypageController addSave " + new Date());
		
		System.out.println(dto.toString());
		// 유저정보 받아오기
		
		// 제품정보 받아오기
		
		// 받아온 정보로 dto 생성
		
		return service.addSave(dto);
	}
	
	// 찜목록 불러오기
	@GetMapping("/getSave")
	public List<MypageSaveDto> getSave() {
		System.out.println("MypageController getSave " + new Date());
		
		return service.getSave();
	}
	
	// 찜 삭제
	@DeleteMapping("/delSave")
	public int delSave(MypageSaveDto dto) {
		System.out.println("MypageController delSave " + new Date());
		
	    return service.delSave(dto);
	}

}
