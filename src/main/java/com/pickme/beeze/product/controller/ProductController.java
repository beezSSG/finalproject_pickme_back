package com.pickme.beeze.product.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	// 전체 상품 목록
	@GetMapping("productlist")
	public List<ProductDto> productlist(ProductDto dto) {
		System.out.println("ProductController productlist" + new Date());
		
		List<ProductDto> productlist = service.productlist(dto);
		for(ProductDto productDto : productlist) {
			System.out.println("ProductDto: " + productDto);
		}		
		return productlist;
	}
	
	
	// 상품 상세보기
	@GetMapping("productdetail")
	public ProductDto productdetail(int id) {
		System.out.println("ProductController productdetail" + new Date());
		
		ProductDto dto = service.productdetail(id);
		
		return dto;
	}
	
	

}
