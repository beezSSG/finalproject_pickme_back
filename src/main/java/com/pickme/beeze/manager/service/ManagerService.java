package com.pickme.beeze.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.manager.dao.ManagerDao;
import com.pickme.beeze.manager.dto.ManagerPurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseOrderParam;
import com.pickme.beeze.manager.dto.OrderChartDto;
import com.pickme.beeze.manager.dto.OrderDto;

@Service
@Transactional
public class ManagerService {

	
	@Autowired
	ManagerDao dao;
	
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
	// 전체 주문 차트 목록 보기
	public List<OrderChartDto> orderchart(OrderDto dto) {
		return dao.orderchart(dto);
	}
}
