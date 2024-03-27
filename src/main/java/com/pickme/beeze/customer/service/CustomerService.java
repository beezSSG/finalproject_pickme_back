package com.pickme.beeze.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.customer.dao.CustomerDao;
import com.pickme.beeze.customer.dto.CartDto;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerDao dao;
	
	/* TODO 장바구니 */
	// 장바구니 담기
	public int getsProductId(String productName, int storeId) {
		return dao.getsProductId(productName,storeId);
	}
	public boolean cartInsert(CartDto dto) {
		int count = dao.cartInsert(dto);
		return count>0?true:false;
	}
	
	// 장바구니 목록 불러오기
	public List<CartDto> getMyCart(int id){
		return dao.getMyCart(id);
	}
	
	public CartDto getMyCartProduct(CartDto dto) {
		return dao.getMyCartProduct(dto);
	}
	
	// 장바구니 물품 수량변경 및 삭제
	public void delCart(CartDto dto) {
		dao.delCart(dto);
	}
	public void changeMyQuantity(CartDto dto) {
		dao.changeMyQuantity(dto);
	}
	

	// 찜 중복 확인
	public boolean checkZZIM(int productId, String customerEmail) {
		return dao.checkZZIM(productId, customerEmail)>0 ? true:false;
	}
	// 상품 찜 추가
	public boolean insertZZIM(int productId, String customerEmail) {
		return dao.insertZZIM(productId, customerEmail)>0 ? true:false;
	}
	// 상품 찜 삭제
	public boolean deleteZZIM(int productId, String customerEmail) {
		return dao.deleteZZIM(productId, customerEmail)>0 ? true:false;
	}
	
	
	// 주문하기
	public boolean order(int id) {
		int count = dao.order(id);
		return count>0?true:false;
	}
}
