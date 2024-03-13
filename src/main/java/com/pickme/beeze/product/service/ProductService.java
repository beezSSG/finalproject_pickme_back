package com.pickme.beeze.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.product.dao.ProductDao;
import com.pickme.beeze.product.dto.ProductDto;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductDao dao;
	
	// 전체 상품 목록
	public List<ProductDto> productlist(ProductDto dto){
		return dao.productlist(dto);
	}
	
	// 상품 상세보기
	public ProductDto productdetail(int id) {
		return dao.productdetail(id);
	}
	

}
