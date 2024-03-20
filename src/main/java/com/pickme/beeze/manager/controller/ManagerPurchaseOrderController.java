package com.pickme.beeze.manager.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.manager.dto.ManagerPurchaseOrderParam;
import com.pickme.beeze.manager.service.ManagerPurchaseOrderService;

@RestController
@RequestMapping("/api/v1/manager/*")
public class ManagerPurchaseOrderController {
	
	@Autowired
	ManagerPurchaseOrderService service;
	
	// 발주 목록 전체보기
	@GetMapping("purchaseorderlist")
	public List<ManagerPurchaseOrderParam> purchaseorderlist(PurchaseDto dto) {
		System.out.println("ManagerPurchaseOrderController purchaseorderlist " + new Date());
		
		return service.purchaseorderlist(dto);
	}
}
