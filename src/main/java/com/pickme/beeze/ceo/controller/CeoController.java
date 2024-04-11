// ceocontroller
package com.pickme.beeze.ceo.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.ceo.dto.CeoInfoDto;
import com.pickme.beeze.ceo.dto.CeoParam;
import com.pickme.beeze.ceo.dto.ProductDto;
import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.ceo.dto.SaleChartDto;
import com.pickme.beeze.ceo.service.CeoService;
import com.pickme.beeze.manager.dto.OrderDto;
import com.pickme.beeze.util.InfoUtil;

import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

 


@RestController
@RequestMapping("api/v1/ceo/*")
public class CeoController {
   
   @Autowired
   CeoService service;
   
   // 점주 정보
   @GetMapping("/getCeoInfo")
   public CeoInfoDto getCeoInfo(Authentication Authentication, HttpServletRequest request) {
	   
		  System.out.println("CeoController getCeoInfo " + new Date());
		  int id = InfoUtil.getUserIdInfo(Authentication, request);
		  CeoInfoDto dto = new CeoInfoDto();
		  dto.setId(id);
		  
	       return service.getCeoInfo(dto);
   }
   
   
   //   발주목록
   @GetMapping("/polist")
   public Map<String, Object> polist(CeoParam param) {
      
      System.out.println("CeoController polist " + new Date());
      System.out.println(param.toString());
      
      //발주 물품 목록
      List<PurchaseDto> list = service.poList(param);  
      
      // 발주 물품 총 수

      
      int count = service.getallceo(param);
      int pageBbs = count / 10;
      if( (count % 10) > 0) {
         pageBbs = pageBbs + 1;
      }
     
      
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("polist", list);
      map.put("pageBbs", pageBbs);
      map.put("cnt", count);
      return map;
   }
   
   // 발주하기
   @GetMapping("/powrite") 
   public List<ProductDto> powrite(CeoParam param) {
      
      System.out.println("CeoController powrite " + new Date());
      
      // 신청 가능한 발주 품목 목록
      List<ProductDto> list = service.powrite(param);
      
      // 카테고리목록
      
      
      System.out.println(list);
         
      return list;
   }
   
   // 발주하기 목록
   @GetMapping("/powriteCn")
   public List<ProductDto> powriteCn(ProductDto dto) {
      
      List<ProductDto> lst = service.powriteCn(dto);
      System.out.println(lst);
      return lst;
   }
   
   // 발주 승인완료 물품 사라지기
	@PostMapping("/deleteProduct")
	public void deleteProduct(ProductDto dto) {
		System.out.println("BbsController deleteProduct " + new Date());
		service.deleteProduct(dto);
	}
	
	
	// 전체 주문 차트 보기
	
	@GetMapping("/salechart")
	public List<SaleChartDto> salechart(OrderDto dto) {
		
		System.out.println("salechartController salechart " + new Date());
		
		System.out.println("salechart :" + dto.toString());
		
		List<SaleChartDto> list = service.salechart(dto);
		System.out.println("SaleChartDto :" + list.toString());
		
		return list;
	}
	
}