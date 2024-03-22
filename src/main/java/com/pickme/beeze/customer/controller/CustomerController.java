package com.pickme.beeze.customer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.customer.dto.CartDto;
import com.pickme.beeze.customer.service.CustomerService;
import com.pickme.beeze.util.InfoUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/customer/*")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	/* TODO 장바구니 */
	// 장바구니 담기
	// react에서 점포 상품수량 초과하지 않도록 제어 [ 상품정보 / 가게아이디 / 상품수량 ]
	@PostMapping("/cart/insert")
	public String cartInsert(Authentication Authentication, HttpServletRequest request, String productName, int storeId, int quantity) {	
		System.out.println("CustomerController cartInsert " + new Date());
		
		// 고객 id 얻기
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		
		// product_id 를 이용해서 sProductId를 가져오기 
		int sProductId = service.getsProductId(productName, storeId);
		
		// cart DB 에 저장
		CartDto dto = new CartDto(sProductId, id, quantity);
		boolean isS = service.cartInsert(dto);		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	} 
	
	// 내 장바구니 목록 불러오기
	@GetMapping("/cart/getCart")
	public List<CartDto> getCart(Authentication Authentication, HttpServletRequest request) {
		System.out.println("CustomerController getCart " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		
		return service.getMyCart(id);
	}
	
	// 장바구니 삭제
	@DeleteMapping("/cart/delCart")
	public List<CartDto> delCart(Authentication Authentication, HttpServletRequest request, CartDto dto) {
		System.out.println("CustomerController delCart " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		dto.setCustomerId(id);
		
		// 장바구니 삭제
		service.delCart(dto);
		
		// 삭제 진행이 완료된 장바구니 목록 불러와서 리턴		
	    return service.getMyCart(id);
	}
	
	// 장바구니 물품별 수량 변경
	// react에서 밸류의 값을 정하지 않고 onchange를 통하여 setQuantity 를 바꾸고 그것이 바뀔때 마다 useeffect를 통하여 axios 호출하도록 하기
	@PostMapping("/cart/changeQuantity")
	public void changeQuantity(Authentication Authentication, HttpServletRequest request, CartDto dto) {
		System.out.println("CustomerController changeQuantity " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		dto.setCustomerId(id);
		
		service.changeMyQuantity(dto);	
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
	
	/* 택배 신청 */
	
	/* 상품 예약 (점주가 확인 후 발주 할 수 있도록 해야함) */
	
}
