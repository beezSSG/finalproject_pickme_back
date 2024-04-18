package com.pickme.beeze.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.customer.dao.CustomerDao;
import com.pickme.beeze.customer.dto.CartDto;
import com.pickme.beeze.customer.dto.PostDto;
import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductParam;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerDao dao;
	
	/* TODO 장바구니 */
	// 장바구니 담기
	public boolean haveMyCart(CartDto dto) {
		int count = dao.haveMyCart(dto);
		return count>0?true:false;
	}
	public int getsProductId(int productId, int storeId) {
		return dao.getsProductId(productId,storeId);
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
	public boolean checkZZIM(int productId, int customerId) {
		return dao.checkZZIM(productId, customerId)>0 ? true:false;
	}
	// 상품 찜 추가
	public boolean insertZZIM(int productId, int customerId) {
		return dao.insertZZIM(productId, customerId)>0 ? true:false;
	}
	// 상품 찜 삭제
	public boolean deleteZZIM(int productId, int customerId) {
		return dao.deleteZZIM(productId, customerId)>0 ? true:false;
	}
	
	// 주문하기
	public void order(CartDto dto) {
	    // #1. 구매한 물품에 대한 주문완료 처리
		dao.order(dto);
	    // #2. 구매물품을 장바구니 화면에서 제거
		dao.buyCart(dto);

	    // #3. 구매물품에 대한 수량을 지점 점포에 수량에 맞춰 처리
		CartDto d = dao.cartQuantity(dto);
		dao.minusStoreProductQuantity(d);
	}
	
	// 택배 예약 신청
	public boolean postreservation(PostDto dto) {
		return dao.postreservation(dto)>0?true:false;
	}
	
	// 상품 예약의 상품 목록 불러오기
	public List<ProductDto> reservationproductlist(ProductParam param) {
		return dao.reservationproductlist(param);
	}
	
	// 매장 번호 가져오기
	public int storeselect(String storename) {
		return dao.storeselect(storename);
	}
	
	// 매장 이름 가져오기
	public String selectstorename(int id) {
		return dao.selectstorename(id);
	}
	
	// 아이디 가져오기
	public String getid(int id) {
		return dao.getid(id);
	}

}
