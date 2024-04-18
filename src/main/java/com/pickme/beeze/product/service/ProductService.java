package com.pickme.beeze.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.product.dao.ProductDao;
import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductGiftDto;
import com.pickme.beeze.product.dto.ProductGiftParam;
import com.pickme.beeze.product.dto.ProductParam;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductDao dao;
	
	// 전체 상품 목록
	public List<ProductDto> productlist(ProductParam param){
		return dao.productlist(param);
	}
	public int getallproduct(ProductParam param) {
		return dao.getallproduct(param);
	}
	
	// 상품 상세보기
	public ProductDto productdetail(int id) {
		return dao.productdetail(id);
	}
	
	// 신제품 등록 (꽌리자)
	public boolean newproductinsert(ProductDto dto) {
		int count = dao.newproductinsert(dto);
		return count>0?true:false;
	}

	
	/* 선물하기 */
	// 선물보내기
	public void sendGift(ProductGiftDto dto) {
		dao.sendGift(dto);
	}
	public ProductGiftParam findFromUser(String phone) {
		return dao.findFromUser(phone);
	};
	
	// 내선물 보기
	public List<ProductGiftDto> getMyGift(int id) {
		return dao.getMyGift(id);
	}
	// 선물 사용
	public void useGift(int id) {
		dao.useGift(id);
	}
	
	// 메인홈 1+1, 2+1, 신제품 목록
	public List<ProductDto> promotedproductlist(int tag) {
		return dao.promotedproductlist(tag);
	}

}
