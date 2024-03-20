package com.pickme.beeze.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.store.dao.StoreProductDao;
import com.pickme.beeze.store.dto.StoreProductParam;


@Service
@Transactional
public class StoreProductService {

	@Autowired
	StoreProductDao dao;
	
	// 매장 상품 목록
	public List<ProductDto> storeproductlist(StoreProductParam param){
		return dao.storeproductlist(param);
	}
	public int getallstoreproduct(StoreProductParam param) {
		return dao.getallstoreproduct(param);
	}
	
}
