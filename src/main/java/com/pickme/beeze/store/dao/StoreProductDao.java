package com.pickme.beeze.store.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.store.dto.StoreProductDto;
import com.pickme.beeze.store.dto.StoreProductParam;

@Mapper
@Repository
public interface StoreProductDao {

	// 매장 상품 목록
	List<ProductDto> storeproductlist(StoreProductParam param);
	int getallstoreproduct(StoreProductParam param);
	
	
}
