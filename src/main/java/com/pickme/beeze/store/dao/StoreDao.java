package com.pickme.beeze.store.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.store.dto.StoreDto;
import com.pickme.beeze.store.dto.StoreProductParam;

@Mapper
@Repository
public interface StoreDao {
	
	// 모든 매장 들고오기
	List<StoreDto> storelist();
	
	// 해당 상품이 있는 매장 목록
	List<StoreDto> matchedstorelist(int id);
	
	// 매장 상품 목록
	List<ProductDto> storeproductlist(StoreProductParam param);
	int getallstoreproduct(StoreProductParam param);

}
