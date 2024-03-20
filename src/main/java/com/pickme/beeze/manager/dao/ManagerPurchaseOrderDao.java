package com.pickme.beeze.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseOrderParam;

@Mapper
@Repository
public interface ManagerPurchaseOrderDao {

	// 발주 목록 전체보기
	List<ManagerPurchaseOrderParam> purchaseorderlist(PurchaseDto dto); 
}
