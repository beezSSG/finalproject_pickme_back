package com.pickme.beeze.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.customer.dto.CartDto;
import com.pickme.beeze.customer.dto.PostDto;
import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductParam;

@Mapper
@Repository
public interface CustomerDao {
	
	/* TODO 장바구니 */
	// 장바구니 담기
	int haveMyCart(CartDto dto);
	int getsProductId(int productId,int storeId);
	int cartInsert(CartDto dto);
	
	// 장바구니 목록 불러오기
	List<CartDto> getMyCart(int id);
	CartDto getMyCartProduct(CartDto dto);
	
	// 장바구니 물품 삭제 및 변경
	void delCart(CartDto dto);
	void changeMyQuantity(CartDto dto);
	
	/* TODO 주문하기 */
	// 주문상품 order 처리
	void order(CartDto dto);
	// 장바구니 제거
	void buyCart(CartDto dto);
	// 점포 수량 변경
	CartDto cartQuantity(CartDto dto);
	void minusStoreProductQuantity(CartDto dto);

	// 찜 중복 확인
	int checkZZIM(int productId, int customerId);
	// 상품 찜 추가
	int insertZZIM(int productId, int customerId);
	// 상품 찜 삭제
	int deleteZZIM(int productId, int customerId);
	
	// 택배 예약 신청
	int postreservation(PostDto dto);

	// 상품 예약의 상품목록 불러오기
	List<ProductDto> reservationproductlist(ProductParam param);
	
	// 매장 번호 가져오기
	int storeselect(String storename);
	// 매장 이름 가져오기
	String selectstorename(int id);
	
}
	