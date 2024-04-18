package com.pickme.beeze.customer.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.customer.dto.CartDto;
import com.pickme.beeze.customer.dto.PostDto;
import com.pickme.beeze.customer.service.CustomerService;
import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductParam;
import com.pickme.beeze.util.InfoUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/customer/*")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	/* TODO 장바구니 */
	// 장바구니 담기
	// react에서 점포 상품수량 초과하지 않도록 제어 [ 상품아이디 / 가게아이디 / 상품수량 ]
	@PostMapping("/cart/insert")
	public String cartInsert(Authentication Authentication, HttpServletRequest request, int sProductId, int quantity) {	
		System.out.println("CustomerController cartInsert " + new Date());
		
		// 고객 id 얻기
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		System.out.println("#1. id찾기도달");
		// cart DB 에 저장
		CartDto dto = new CartDto();
		dto.setSProductId(sProductId);
		dto.setQuantity(quantity);
		dto.setCustomerId(id);
		System.out.println("#2. 제대로도달");
		boolean isS = service.haveMyCart(dto);		
		if(isS) {
			return "YES";
		}
		else {
			service.cartInsert(dto);
			return "NO";
		}
	} 
	
	// 내 장바구니 목록 불러오기
	@GetMapping("/cart/getCart")
	public List<CartDto> getCart(Authentication Authentication, HttpServletRequest request) {
		System.out.println("CustomerController getCart " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		//System.out.println(id);
		List<CartDto> list = service.getMyCart(id);
		
		List<CartDto> li = new ArrayList<CartDto>();
		// 점포 상품번호를 통해 상품가격 / 상품이미지 / 상품이름
		for (CartDto dto : list) {
			CartDto d = service.getMyCartProduct(dto);
			d.setId(dto.getId());
			d.setCustomerId(dto.getCustomerId());
			d.setSProductId(dto.getSProductId());
			d.setQuantity(dto.getQuantity());
			li.add(d);
		}
		
		return li;
	}
	
	// 장바구니 삭제
	@DeleteMapping("/cart/delCart/{sProductId}")
	public void delCart(Authentication Authentication, HttpServletRequest request, @PathVariable Integer sProductId) {
		System.out.println("CustomerController delCart " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		CartDto dto = new CartDto();
		dto.setSProductId(sProductId);
		dto.setCustomerId(id);
		
		System.out.println(dto.toString());
		// 장바구니 삭제
		service.delCart(dto);
		
	}
	
	// 장바구니 물품별 수량 변경
	// react에서 밸류의 값을 정하지 않고 onchange를 통하여 setQuantity 를 바꾸고 그것이 바뀔때 마다 useeffect를 통하여 axios 호출하도록 하기
	@PostMapping("/cart/changeQuantity")
	public void changeQuantity(Authentication Authentication, HttpServletRequest request, CartDto dto) {
		System.out.println("CustomerController changeQuantity " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		dto.setCustomerId(id);
		System.out.println(dto.toString());
		
		service.changeMyQuantity(dto);	
	}
	
	/* 찜하기 */
	@GetMapping("/checkZZIM")
	public String checkZZIM(int productId, Authentication Authentication, HttpServletRequest request) {
		System.out.println("CustomerController checkZZIM " + new Date());

		int customerId = InfoUtil.getUserIdInfo(Authentication, request);
		System.out.println(productId + ":" + customerId);
		
		boolean isS = service.checkZZIM(productId, customerId);		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	
	@PostMapping("/insertZZIM")
	public String insertZZIM(int productId, Authentication Authentication, HttpServletRequest request) {
		System.out.println("CustomerController insertZZIM " + new Date());
		
		int customerId = InfoUtil.getUserIdInfo(Authentication, request);
		boolean isS = service.insertZZIM(productId, customerId);		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}
	
	@PostMapping("/deleteZZIM")
	public String deleteZZIM(int productId, Authentication Authentication, HttpServletRequest request) {
		System.out.println("CustomerController deleteZZIM " + new Date());

		int customerId = InfoUtil.getUserIdInfo(Authentication, request);
		boolean isS = service.deleteZZIM(productId, customerId);		
		if(isS) {
			return "YES";
		}
		else {
			return "NO";
		}
	}

	// 주문하기
	@PostMapping("/order")
	public String order(@RequestBody RequestData requestData) { // 장바구니 id 목록
	    System.out.println("CustomerController order " + new Date());
	    List<Integer> checkItems = requestData.getCheckItems();
	    int pickDel = requestData.getPickDel();
	    
	    CartDto dto = new CartDto();
	    dto.setPickDel(pickDel);
	    
	    System.out.println(checkItems);
	    for (Integer id : checkItems) {
	    	// System.out.println(id);
	    	dto.setId(id);
	        service.order(dto);	        
	    }
	    return "제대로 작업이 완료되었습니다";
	}
	
	// 프론트에서 개떡같이 보냈을때 스태틱 클래스를 통해 받아야할 값을 정확하게 지정해주고 가져올 수 있다.
	static class RequestData {
        private List<Integer> checkItems;
        private int pickDel;

        public List<Integer> getCheckItems() {
            return checkItems;
        }

        public void setCheckItems(List<Integer> checkItems) {
            this.checkItems = checkItems;
        }

        public int getPickDel() {
            return pickDel;
        }

        public void setPickDel(int pickDel) {
            this.pickDel = pickDel;
        }
    }
	
	// 택배 신청하기
	@PostMapping("postreservation") 
	public String postreservation(Authentication Authentication, HttpServletRequest request, PostDto dto) {
		
		System.out.println("CustomerController test " + new Date());	
    	
    	int id = InfoUtil.getUserIdInfo(Authentication, request);
    	System.out.println("id = " + id);
    	dto.setCustomerId(id);
    	System.out.println("PostDto : " + dto.toString());
    	
    	boolean isS = service.postreservation(dto);
    	
    	if(isS) {
    		return "YES";
    	}
    	else {
    		return "NO";
    	}
	}
	
	/* 상품 예약 (점주가 확인 후 발주 할 수 있도록 해야함) */
	// 상품 예약 상품리스트 보기
	@GetMapping("reservationproductlist")
	public List<ProductDto> reservationproductlist(ProductParam param) {
		
		System.out.println(param.toString());
		
	    int start = (param.getPageNumber() - 1) * param.getPerPage();
	    param.setStart(start);
	    return service.reservationproductlist(param);
	}
	
	
	// 매장 번호 가져오기(상품 예약)
	@GetMapping("storeselect")
	public int storeselect(String storename) {
		
		System.out.println("storeselect");
		
		return service.storeselect(storename);
	}
	
	// 매장 번호 가져오기(상품 예약)
	@GetMapping("selectstorename")
	public String storeselect(int id) {
		
		System.out.println("selectstorename");
		
		return service.selectstorename(id);
	}
	
	// 아이디 얻기
	@GetMapping("getid")
	public String getid(Authentication Authentication, HttpServletRequest request ) {
		
		System.out.println("customercontroller getid");
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		
		return service.getid(id);
	}


	
}
