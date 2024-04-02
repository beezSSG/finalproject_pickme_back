package com.pickme.beeze.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductParam;

@Mapper
@Repository
public interface ProductDao {
	
	// 상품
	
	// 전체 상품 목록
	List<ProductDto> productlist(ProductParam param);
	int getallproduct(ProductParam param);
	
	// 상품 상세보기
	ProductDto productdetail(int id);
	
	// 신제품 등록(관리자)
	int newproductinsert(ProductDto dto);

  
	

}
