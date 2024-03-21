package com.pickme.beeze.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseOrderParam;

@Mapper
@Repository
public interface ManagerPurchaseOrderDao {

	// 발주 목록 전체보기
	List<ManagerPurchaseOrderParam> purchaseorderlist(ManagerPurchaseDto dto); 
	// 발주 승인하기
	void purchaseorderapprove(int id);
	// 목록 총 수
	int getPurchaseOrderCount(ManagerPurchaseDto dto);
}
