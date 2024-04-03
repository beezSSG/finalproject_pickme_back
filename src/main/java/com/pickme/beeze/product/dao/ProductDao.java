package com.pickme.beeze.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductGiftDto;
import com.pickme.beeze.product.dto.ProductGiftParam;
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

  
	
	/* 선물하기 */
	// 선물보내기
	void sendGift(ProductGiftDto dto);
	ProductGiftParam findFromUser(String name);
	// 내선물 보기
	List<ProductGiftDto> getMyGift(int id);
	
	// 선물 사용
	void useGift(int id);
	

}
