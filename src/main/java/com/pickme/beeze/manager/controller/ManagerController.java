package com.pickme.beeze.manager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseOrderParam;
import com.pickme.beeze.manager.dto.OrderChartDto;
import com.pickme.beeze.manager.dto.OrderDto;
import com.pickme.beeze.manager.service.ManagerService;

@RestController
@RequestMapping("/api/v1/manager/*")
public class ManagerController {
	
	@Autowired
	ManagerService service;
	
	// 발주 목록 전체보기
	@GetMapping("purchaseorderlist")
	public Map<String, Object> purchaseorderlist(ManagerPurchaseDto dto) {
		System.out.println("ManagerPurchaseOrderController purchaseorderlist " + new Date());
		
		System.out.println(dto.toString());
		
		List<ManagerPurchaseOrderParam> purchaseorderList = service.purchaseorderlist(dto);
		System.out.println(purchaseorderList);
		
		int count = service.getPurchaseOrderCount(dto);
		int pageBbs = count / 10;
		if((count % 10) > 0) {
			pageBbs = pageBbs + 1;
		}
		System.out.println(count);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseorderList", purchaseorderList);
		map.put("pageBbs", pageBbs);
		map.put("cnt", count);
		
		return map;
	}
	
	// 발주 승인 기능
	@GetMapping("purchaseorderapprove")
	public Map<String, Object> purchaseorderapprove(ManagerPurchaseDto dto) {
		System.out.println("ManagerPurchaseOrderController purchaseorderlist " + new Date());
		
		service.purchaseorderapprove(dto.getId());
		List<ManagerPurchaseOrderParam> purchaseorderList = service.purchaseorderlist(dto);
		
		int count = service.getPurchaseOrderCount(dto);
		int pageBbs = count / 10;
		if((count % 10) > 0) {
			pageBbs = pageBbs + 1;
		}
		System.out.println(count);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("purchaseorderList", purchaseorderList);
		map.put("pageBbs", pageBbs);
		map.put("cnt", count);
		
		return map;
	}
	
	// 전체 주문 차트 보기
	@GetMapping("orderchart")
	public List<OrderChartDto> orderchart(OrderDto dto) {
		
		System.out.println("OrderChartController orderchart " + new Date());
		
		System.out.println("OderDto :" + dto.toString());
		
		return service.orderchart(dto);
	}
}
