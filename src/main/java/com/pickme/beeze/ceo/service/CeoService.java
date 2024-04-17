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
import com.pickme.beeze.ceo.dto.PurchaseProductDto;
import com.pickme.beeze.ceo.dto.SalesChartDto;
import com.pickme.beeze.ceo.dto.OrderDto;
import com.pickme.beeze.ceo.dto.PostDto;

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
	
	public boolean powritefinal(List<PurchaseProductDto> list) {
	    for (PurchaseProductDto dto : list) {
	        int count = dao.powritefinal(dto);
	        if (count <= 0) {
	            // 쓰기 작업 실패 시 즉시 false 반환
	            return false;
	        }
	    }
	    // 모든 쓰기 작업이 성공한 경우 true 반환
	    return true;
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
	
	// 화면에서 승인이 완료된 물품을 사라지게 하기 
	public void deleteProduct(PurchaseDto dto) {
		dao.deleteProduct(dto);
	}
	
	// 재고 넣어주기
	public int addProduct(InventoryDto dto) {
		return dao.addProduct(dto);
	}
	
	public List<SalesChartDto> saleschart(OrderDto dto) {
		return dao.saleschart(dto);
	}
	
	// 재고
	public List<InventoryDto> inventory(InventoryDto dto) {	
		return dao.inventory(dto);	
	}
	
	// 픽업
	public List<OrderDto> pickup(OrderDto dto) {	
		List<OrderDto> list = dao.pickup(dto);
		return list;	
	}
	
	
	// 배달
	public List<PostDto> postcheck(PostDto dto) {	
		List<PostDto> list = dao.postcheck(dto);
		return list;	
	}
}
