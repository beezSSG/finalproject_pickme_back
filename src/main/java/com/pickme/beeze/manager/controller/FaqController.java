package com.pickme.beeze.manager.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.manager.dto.FaqDto;
import com.pickme.beeze.manager.dto.FaqParam;
import com.pickme.beeze.manager.service.FaqService;

@RestController
@RequestMapping("/api/v1/manager/*")
public class FaqController {

	@Autowired
	FaqService service;
	
	// faq 리스트
	@GetMapping("/faqlist")
	public List<FaqDto> faqlist(FaqParam param) {
		
		System.out.println("FaqController faqlist " + new Date());
		
		List<FaqDto> faqlist = service.faqlist(param);
		
		return faqlist;
	}
	
	// faq 생성
	@GetMapping("/faqcreate")
	public String faqcreate(FaqDto dto) {
		
		System.out.println("FaqController faqcreate " + new Date());
		
		boolean isS = service.faqcreate(dto);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
		
	}
	
	// faq 삭제
	@GetMapping("/faqdelete")
	public String faqdelete(int id) {
		
		System.out.println("FaqController faqdelete " + new Date());
		
		boolean isS = service.faqdelete(id);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}

	}
	
	// faq 조회수
	@GetMapping("/faqreadcount")
	public void faqreadcount(int id) {
		
		System.out.println("FaqController faqreadcount " + new Date());
		service.faqreadcount(id);
	}
	
	// top faq 리스트
	@GetMapping("/topfaqlist")
	public List<FaqDto> topfaqlist(FaqDto dto) {
		
		System.out.println("FaqController topfaqlist " + new Date());
		
		return service.topfaqlist(dto);
	}
}
