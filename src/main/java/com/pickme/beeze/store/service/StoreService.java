package com.pickme.beeze.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<StoreDto> searchstore() {
		return dao.searchstore();
	}

	// 해당 상품이 있는 매장 목록
	public List<StoreDto> matchedstorelist(int id){
		return dao.matchedstorelist(id);
	}

}
