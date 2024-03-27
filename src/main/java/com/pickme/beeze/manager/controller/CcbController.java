package com.pickme.beeze.manager.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.manager.dto.CcbParam;
import com.pickme.beeze.manager.dto.CcbaDto;
import com.pickme.beeze.manager.service.CcbService;

@RestController
@RequestMapping("/api/v1/manager/*")
public class CcbController {

	@Autowired
	CcbService service;
	
	// 1대1 문의 목록 게시판 
	@GetMapping("/ccblist")
	public List<CcbDto> ccblist(CcbDto dto) {
		System.out.println("CcbController ccblist " + new Date());
		
		List<CcbDto> ccblist = service.ccblist(dto);
		for (CcbDto ccbDto : ccblist) {
			System.out.println("CcbDto : " + ccbDto);
		}
		
		return ccblist;
	}
	
	// 카테고리 별 글 개수
	@GetMapping("/ccbcategorycount")
	public List<CcbParam> ccbcategorycount(CcbDto dto) {
		System.out.println("CcbController ccbcategorycount " + new Date());
		
		List<CcbParam> ccbcategorycountlist = service.ccbcategorycount(dto);
		for (CcbParam ccbParam : ccbcategorycountlist) {
			System.out.println("CcbDto : " + ccbParam);
		}
		
		return ccbcategorycountlist;
	}
	
	// 게시판 글 링크를 눌렸을 경우 상세화면
	@GetMapping("/ccbdetail")
	public CcbDto ccbdetail(int id) {
		System.out.println("CcbController ccbdetail " + new Date());
		
		CcbDto dto = service.ccbdetail(id);
		
		return dto;
	}
	
	// 게시판 글 지우기
	@GetMapping("/ccbdelete")
	public List<CcbDto> ccbdelete(CcbDto dto) {
		System.out.println("CcbController ccbdelete " + new Date());
		
		service.ccbdelete(dto.getId());
		
		return service.ccblist(dto);
	}
	
	// 댓글 불러오기
	@GetMapping("/ccbcommentlist")
	public List<CcbaDto> ccbcommentlist(int ccbId) {
		System.out.println("CcbController ccbcommentlist " + new Date());
		
		List<CcbaDto> ccbalist = service.ccbcommentlist(ccbId);
		
		return ccbalist;
	}
	
	// 관리자 댓글 달기
	@GetMapping("/ccbcommentwrite")
	public List<CcbaDto> ccbcommentwrite(CcbaDto dto) {
		
		service.ccbcommentwrtie(dto);
		
		// 댓글 단 후 상태 변화
		service.ccbcommentwriteAf(dto);
		
		return service.ccbcommentlist(dto.getCcbId());
	
	}
	
	// 관리자 댓글 수정
	//@GetMapping("commentupdate")
	// 관리자 댓글 삭제
	@GetMapping("/ccbcommentdelete")
	public List<CcbaDto> ccbcommentdelete(CcbaDto dto) {
		
		System.out.println("CcbController ccbcommentdelete " + new Date());
		
		System.out.println(dto.toString());
		
		service.ccbcommentdelete(dto.getId());
		
		return service.ccbcommentlist(dto.getCcbId());
	}
	
	// 1:1 문의 답변 안된 리스트 개수
	@GetMapping("/notanswercount")
	public int notanswercount(CcbDto dto) {
		
		System.out.println("CcbController notanswercount " + new Date());
		
		return service.notanswercount(dto);
	}
	
}