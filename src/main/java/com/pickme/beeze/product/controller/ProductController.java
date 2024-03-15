package com.pickme.beeze.product.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductParam;
import com.pickme.beeze.product.dto.ProductReview;
import com.pickme.beeze.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/product/*")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	// 전체 상품 목록
	@GetMapping("/productlist")
	public Map<String, Object> bbslist(ProductParam param){
		System.out.println("ProductController productlist " + new Date());
		System.out.println(param.toString());
		
		
		// 글목록
		List<ProductDto> productlist = service.productlist(param);
		
		// 글의 총갯수
		int count = service.getallproduct(param);
		int pageBbs = count / 8;
		if((count % 8) > 0) {
			pageBbs = pageBbs + 1;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productlist", productlist);
		map.put("pageBbs", pageBbs);
		map.put("cnt", count);
		
		return map;		
	}
	
	// 상품 상세보기
	@GetMapping("/productdetail")
	public ProductDto productdetail(int id) {
		System.out.println("ProductController productdetail" + new Date());		
		
		return service.productdetail(id);
	}
	
	
	// 신제품 등록
	@GetMapping("/newproductinsert")
	public String newproductinsert(ProductDto dto) {
		System.out.println("ProductController newproductinsert" + new Date());
		
		boolean isS = service.newproductinsert(dto);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	
	
	// 후기 목록
	@GetMapping("/productReviewList")
	public List<ProductReview> productReviewtList(int id) {
		System.out.println("ProductController productReviewtList " + new Date());
	
		return service.productReviewtList(id);
	}
	

}
