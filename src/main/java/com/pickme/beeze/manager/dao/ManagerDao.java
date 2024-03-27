package com.pickme.beeze.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseOrderParam;
import com.pickme.beeze.manager.dto.OrderChartDto;
import com.pickme.beeze.manager.dto.OrderDto;

@Mapper
@Repository
public interface ManagerDao {

	// 발주 목록 전체보기
	List<ManagerPurchaseOrderParam> purchaseorderlist(ManagerPurchaseDto dto); 
	// 발주 승인하기
	void purchaseorderapprove(int id);
	// 목록 총 수
	int getPurchaseOrderCount(ManagerPurchaseDto dto);
	// 전체 주문 차트 보기
	List<OrderChartDto> orderchart(OrderDto dto);
	// 발주 안된 목록 개수
	int notpocount(ManagerPurchaseDto dto);
}
