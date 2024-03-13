package com.pickme.beeze.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.product.dto.ProductDto;

@Mapper
@Repository
public interface ProductDao {
	
	// 상품
	
	// 전체 상품 목록
	List<ProductDto> productlist(ProductDto dto);
	
	// 상품 상세보기
	ProductDto productdetail(int id);
	
	

}
