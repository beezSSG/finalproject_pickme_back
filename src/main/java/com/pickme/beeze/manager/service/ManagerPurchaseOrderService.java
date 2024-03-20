package com.pickme.beeze.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.manager.dao.ManagerPurchaseOrderDao;
import com.pickme.beeze.manager.dto.ManagerPurchaseOrderParam;

@Service
@Transactional
public class ManagerPurchaseOrderService {

	
	@Autowired
	ManagerPurchaseOrderDao dao;
	
	// 발주 목록 전체보기
	public List<ManagerPurchaseOrderParam> purchaseorderlist(PurchaseDto dto) {
		return dao.purchaseorderlist(dto);
	}
}
