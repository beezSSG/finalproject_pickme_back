package com.pickme.beeze.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.manager.dao.ManagerPurchaseOrderDao;
import com.pickme.beeze.manager.dto.ManagerPurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseOrderParam;

@Service
@Transactional
public class ManagerPurchaseOrderService {

	
	@Autowired
	ManagerPurchaseOrderDao dao;
	
	// 발주 목록 전체보기
	public List<ManagerPurchaseOrderParam> purchaseorderlist(ManagerPurchaseDto dto) {
		return dao.purchaseorderlist(dto);
	}
	// 발주 승인하기
	public void purchaseorderapprove(int id) {
		dao.purchaseorderapprove(id);
	}
	// 목록 총 수
	public int getPurchaseOrderCount(ManagerPurchaseDto dto) {
		return dao.getPurchaseOrderCount(dto);
	}
}
