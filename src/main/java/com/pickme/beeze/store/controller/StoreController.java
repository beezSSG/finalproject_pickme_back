package com.pickme.beeze.store.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.store.dto.StoreDto;
import com.pickme.beeze.store.service.StoreService;

@RestController
@RequestMapping("/api/v1/store/*")
public class StoreController {
	
	@Autowired
	StoreService service;	

	// 해당 상품이 있는 매장 목록
	@GetMapping("/matchedstorelist")
	public List<StoreDto> matchedstorelist(int id){
		System.out.println("StoreController matchedstorelist " + new Date());
		return service.matchedstorelist(id);
	}

}