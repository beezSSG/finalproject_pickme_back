package com.pickme.beeze.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.customer.dto.CartDto;

@Mapper
@Repository
public interface CustomerDao {
	
	/* TODO 장바구니 */
	// 장바구니 담기
	int getsProductId(String productName,int storeId);
	int cartInsert(CartDto dto);
	
	// 장바구니 목록 불러오기
	List<CartDto> getMyCart(int id);
	CartDto getMyCartProduct(CartDto dto);
	
	// 장바구니 물품 삭제 및 변경
	void delCart(CartDto dto);
	void changeMyQuantity(CartDto dto);
	
	// 주문하기
	int order(int id);

	// 찜 중복 확인
	int checkZZIM(int productId, String customerEmail);
	// 상품 찜 추가
	int insertZZIM(int productId, String customerEmail);
	// 상품 찜 삭제
	int deleteZZIM(int productId, String customerEmail);

}
