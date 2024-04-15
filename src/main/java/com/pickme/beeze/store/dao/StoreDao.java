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
	
	// 검색한 결과값을 매장명에 포함한 매장 목록 모두 들고오기
	List<StoreDto> searchstore(String stateName, String districtName, String storeName);
	
	// 해당 상품이 있는 매장 목록
	List<StoreDto> matchedstorelist(int id);
	
	// 매장 정보 불러오기
	StoreDto storeinfo(int id);
	
	// 매장 상품 목록
	List<ProductDto> storeproductlist(StoreProductParam param);
	int getallstoreproduct(StoreProductParam param);
	
	// 지도 영역에 있는 매장 목록
	List<StoreDto> getstoresinmap(Double swLat, Double nwLat, Double nwLng, Double neLng);

}
