package com.pickme.beeze.ceo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.ceo.dto.CeoInfoDto;
import com.pickme.beeze.ceo.dto.CeoParam;
import com.pickme.beeze.ceo.dto.ProductDto;
import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.ceo.dto.SaleChartDto;
import com.pickme.beeze.manager.dto.OrderDto;

@Mapper
@Repository
public interface CeoDao {
	
	List<CeoInfoDto> getCeoInfo(CeoInfoDto dto);
	
	List<PurchaseDto> polist(CeoParam param);
	int getallceo(CeoParam param);
	
	List<ProductDto> powrite(CeoParam param);
	List<ProductDto> powriteCn(ProductDto dto);
	
	int deleteProduct(int id);
	
	// 전체 주문 차트 보기
	List<SaleChartDto> salechart(OrderDto dto);
	
}
