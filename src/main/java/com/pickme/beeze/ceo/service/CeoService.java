package com.pickme.beeze.ceo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.ceo.dao.CeoDao;
import com.pickme.beeze.ceo.dto.CeoInfoDto;
import com.pickme.beeze.ceo.dto.CeoParam;
import com.pickme.beeze.ceo.dto.InventoryDto;
import com.pickme.beeze.ceo.dto.ProductDto;
import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.ceo.dto.SaleChartDto;
import com.pickme.beeze.ceo.dto.OrderDto;

@Service
@Transactional
public class CeoService {
	
	@Autowired
	CeoDao dao;
	
	public CeoInfoDto getCeoInfo(CeoInfoDto dto) {
		
		return dao.getCeoInfo(dto);
	}
	
	public List<PurchaseDto> poList(CeoParam param) {
		return dao.polist(param);	
	}

	public int getallceo(CeoParam param) {
		return dao.getallceo(param);
	}
	
	public List<ProductDto> powrite(CeoParam param) { 
		return dao.powrite(param);
	 }
	
	public List<ProductDto> powriteCn(ProductDto dto) {
		return dao.powriteCn(dto);
	}
	
	public void deleteProduct(ProductDto dto) {
		dao.deleteProduct(dto);
	}
	
	public List<SaleChartDto> salechart(OrderDto dto) {
		return dao.salechart(dto);
	}
	
	// 재고
	public List<InventoryDto> inventory(InventoryDto dto) {	
		return dao.inventory(dto);	
	}
	
	// 픽업
	public List<OrderDto> pickup(OrderDto dto) {	
		List<OrderDto> list = dao.pickup(dto);
		System.out.println(list.size());
		return list;	
	}
	
}
