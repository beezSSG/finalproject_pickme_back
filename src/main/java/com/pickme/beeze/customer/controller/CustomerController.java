package com.pickme.beeze.customer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping("/cartinsert")
	public String cartinsert(String productName, int storeId, String email, int quantity) {	// front에서 상품정보를 보낼때 편의점을 검색해서(편의점id) -> 상품 선택(상품명) -> 상품 수량 선택(상품수)
		System.out.println("CustomerController cartinsert " + new Date());
		
		// 카트dto 에는 customer_id 랑 s_product_id 랑 order_yn 이 담겨져있음
		// 근데 front 에서 가져오는 정보는 상품명과 개수이다. 흠.... 상품명인 id를 가져온다
		// productName 으로 id를 꺼내온다. --> join으로 처리함!
		// product_id 를 이용해서 sProductId를 가져오고 email을 가지고 cutomerId를 가져온다. 
		int sProductId = service.getsProductId(productName,storeId);
		// email로 cutomer_id 받아오기
		int customerId = service.getCustomerId(email);	
		CartDto dto = new CartDto(sProductId, customerId, quantity);
		// cart DB 에 저장
		boolean isS = service.cartinsert(dto);
		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	
	}  
	
	// 주문하기
	@GetMapping("/order")
	public String order(@RequestParam List<Integer> ids) { // 장바구니 id 목록
	    System.out.println("CustomerController order " + new Date());
	    
	    // 각 장바구니 id에 대해 주문을 처리
	    for (Integer id : ids) {
	        boolean isS = service.order(id);
	        if (!isS) {
	            return "NO";
	        }
	    }
	    
	    return "YES";
	}


	
	
	
	
	// 택배 신청
	
	// 상품 예약 (점주가 확인 후 발주 할 수 있도록 해야함)
	
}
