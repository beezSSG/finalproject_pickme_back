package com.pickme.beeze.ceo.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.ceo.dto.CeoInfoDto;
import com.pickme.beeze.ceo.dto.CeoParam;
import com.pickme.beeze.ceo.dto.InventoryDto;
import com.pickme.beeze.ceo.dto.ProductDto;
import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.ceo.dto.PurchaseProductDto;
import com.pickme.beeze.ceo.dto.SalesChartDto;
import com.pickme.beeze.customer.dto.ProductReservationDto;
import com.pickme.beeze.ceo.dto.OrderDto;
import com.pickme.beeze.ceo.dto.PostDto;

@Mapper
@Repository
public interface CeoDao {
	
	CeoInfoDto getCeoInfo(CeoInfoDto dto);
	
	List<PurchaseDto> polist(CeoParam param);
	int getallceo(CeoParam param);
	
	List<ProductDto> powrite(CeoParam param);
	List<ProductDto> powriteCn(ProductDto dto);
	
	// 발주발주발주
	int powritefinal(PurchaseProductDto dto);
	
	// 화면에서 승인이 완료된 물품을 사라지게 하기
	void deleteProduct(PurchaseDto dto);
	
	// 재고 넣어주기
	int addProduct(InventoryDto dto);
	
	// 전체 주문 차트 보기
	List<SalesChartDto> saleschart(OrderDto dto);
	
	// 재고 현황 불러오기
	List<InventoryDto> inventory(InventoryDto param);
	// 재고 현황 총 수
	int getallinven(InventoryDto dto);
	
	// 픽업 기능 구현하기
	List<OrderDto> pickup(OrderDto dto);
	
	// 화면에서 픽업이 완료된 물품을 사라지게 하기
	void deletepickup(OrderDto dto);
	
	int getallpickup(OrderDto dto);
	
	// 배달 기능 구현하기
	
	List<PostDto> postcheck(PostDto dto);
	
	// 상품 예약 목록 가져오기
	List<ProductReservationDto> getrplist(ProductReservationDto dto);
	// 총 수
	int getallrp(ProductReservationDto dto);
	// 예약 승인
	void checkrp(int id);

	
}
