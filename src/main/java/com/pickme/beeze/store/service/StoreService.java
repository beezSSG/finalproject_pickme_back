package com.pickme.beeze.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.store.dao.StoreDao;
import com.pickme.beeze.store.dto.StoreDto;

@Service
@Transactional
public class StoreService {

	@Autowired
	StoreDao dao;
	
	// 모든 매장 목록
	public List<StoreDto> storelist() {
		return dao.storelist();
	}
	
	// 검색한 결과값을 매장명에 포함한 매장 목록 모두 들고오기
	public List<StoreDto> searchstore(String stateName, String districtName, String storeName) {
		return dao.searchstore(stateName, districtName, storeName);
	}

	// 해당 상품이 있는 매장 목록
	public List<StoreDto> matchedstorelist(int id){
		return dao.matchedstorelist(id);
	}
	
	// 매장 정보 불러오기
	public StoreDto storeinfo(int id) {
		return dao.storeinfo(id);
	}
		
	// 지도 영역에 있는 매장 목록
	public List<StoreDto> getstoresinmap(Double swLat, Double nwLat, Double nwLng, Double neLng){
		return dao.getstoresinmap(swLat, nwLat, nwLng, neLng);
	}

}
