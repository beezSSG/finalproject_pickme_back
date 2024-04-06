package com.pickme.beeze.store.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.store.dto.StoreProductDto;
import com.pickme.beeze.store.dto.StoreProductParam;
import com.pickme.beeze.store.service.StoreProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/store/*")
public class StoreProductController {
	
	@Autowired
	StoreProductService service;
	
	// 매장 상품 목록
	@GetMapping("/storeproductlist")
	public Map<String, Object> storeproductlist(StoreProductParam param) {
		System.out.println("StoreProductController storeproductlist " + new Date());
		System.out.println(param.toString());
		
		// 글 목록
		List<ProductDto> storeproductlist = service.storeproductlist(param);
		
		// 글의 총 갯수 
		int count = service.getallstoreproduct(param);
		int pageBbs = count / 10;
		if((count % 10) > 0) {
			pageBbs = pageBbs + 1;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("storeproductlist", storeproductlist);
		map.put("pageBbs", pageBbs);
		map.put("cnt", count);
		
		return map;	
	}
	

}
