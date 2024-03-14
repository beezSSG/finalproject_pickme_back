package com.pickme.beeze.customer.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.customer.dto.CartDto;
import com.pickme.beeze.customer.service.CustomerService;
import com.pickme.beeze.mypage.dto.MypageCartDto;

@RestController
@RequestMapping("/api/v1/customer/*")
public class CustomerController {

	@Autowired
	CustomerService service;

	// 장바구니 담기
	@GetMapping("/cartinsert")
	public String cartinsert(String productName,String email) {
		System.out.println("CustomerController cartinsert " + new Date());
		
		// 카트dto 에는 customer_id 랑 s_product_id 랑 order_yn 이 담겨져있음
		// 근데 front 에서 가져오는 정보는 상품명과 개수이다. 흠.... 상품명인 id를 가져온다
		// productName 으로 id를 꺼내온다.
		int productId = service.getProductId(productName);
		// product_id 를 이용해서 sProductId를 가져오고 email을 가지고 cutomerId를 가져온다.
		int sProductId = service.getsProductId(productId);
		// email로 cutomer_id 받아오기
		int customerId = service.getCustomerId(email);
		
		// cart DB 에 저장
		boolean isS = service.cartinsert(sProductId, customerId);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	
	}  
	
	// 주문하기
	@GetMapping("/order")
	public String order(int id) {
		System.out.println("CustomerController order " + new Date());
		
		// order DB 에 저장
		boolean isS = service.order(id);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	
	
	// 택배 신청
	
	// 상품 예약 (점주가 확인 후 발주 할 수 있도록 해야함)
	
}
