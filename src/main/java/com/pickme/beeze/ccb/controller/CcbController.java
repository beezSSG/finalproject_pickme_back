package com.pickme.beeze.ccb.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.ccb.dto.CcbDto;
import com.pickme.beeze.ccb.dto.CcbaDto;
import com.pickme.beeze.ccb.service.CcbService;

@RestController
public class CcbController {

	@Autowired
	CcbService service;
	
	// 1대1 문의 목록 게시판 
	@GetMapping("ccblist")
	public List<CcbDto> ccblist(CcbDto dto) {
		
		System.out.println("CcbController ccblist " + new Date());
		
		List<CcbDto> ccblist = service.ccblist(dto);
		for (CcbDto ccbDto : ccblist) {
			System.out.println("CcbDto : " + ccbDto);
		}
		
		return ccblist;
	}
	
	// 게시판 글 링크를 눌렸을 경우 상세화면
	@GetMapping("ccbdetail")
	public CcbDto ccbdetail(int id) {
		
		System.out.println("CcbController ccbdetail " + new Date());
		
		CcbDto dto = service.ccbdetail(id);
		
		return dto;
	}
	
	// 관리자 댓글 달기
	@GetMapping("ccbcommentwrite")
	public String ccbcommentwrite(CcbaDto dto) {
		System.out.println("CcbController ccbcommentwrite " + new Date());
		
		boolean isS = service.ccbcommentwrtie(dto);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	
	// 관리자 댓글 삭제
	@GetMapping("ccbcommentdelete")
	public String ccbcommentdelete(int id) {

		System.out.println("CcbController ccbcommentdelete " + new Date());
		
		boolean isS = service.ccbcommentdelete(id);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
}
