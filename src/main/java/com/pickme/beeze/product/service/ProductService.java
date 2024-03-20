package com.pickme.beeze.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.product.dao.ProductDao;
import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductParam;
import com.pickme.beeze.product.dto.ProductReview;

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
	
	// 후기 목록
	public List<ProductReview> productReviewtList(int id){
		return dao.productReviewList(id);
	}
	
	
	

}
