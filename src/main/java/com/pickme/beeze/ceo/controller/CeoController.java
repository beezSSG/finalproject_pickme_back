package com.pickme.beeze.ceo.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.ceo.dto.CeoParam;
import com.pickme.beeze.ceo.dto.ProductDto;
import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.ceo.service.CeoService;
import org.springframework.web.bind.annotation.GetMapping; 


@RestController
public class CeoController {
	
	@Autowired
	CeoService service;
	
	//	발주목록
	@GetMapping("polist")
	public Map<String, Object> polist(CeoParam param) {
		
		System.out.println("CeoController polist " + new Date());
		
		//발주 물품 목록
		List<PurchaseDto> list = service.poList(param);  
		
		// 발주 물품 총 수
		int count = service.getallceo(param);
		int pageBbs = count / 10;
		if( (count % 10) > 0) {
			pageBbs = pageBbs + 1;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("polist", list);
		map.put("pageBbs", pageBbs);
		map.put("cnt", count);
		return map;
	}
	
	// 발주하기
	@GetMapping("powrite") 
	public ProductDto powrite(CeoParam param) {
		
		System.out.println("CeoController powrite " + new Date());
		
		// 신청 가능한 발주 품목 목록
		List<ProductDto> list = service.powrite(param);
		
		// 카테고리아이디
		ProductDto cnId = service.powriteCn(param);
		
		System.out.println(list);
		
		System.out.println(cnId);
		
		return cnId;
	}

}
