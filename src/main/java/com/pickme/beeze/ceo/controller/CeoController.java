// ceocontroller
package com.pickme.beeze.ceo.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.ceo.dto.CeoInfoDto;
import com.pickme.beeze.ceo.dto.CeoParam;
import com.pickme.beeze.ceo.dto.InventoryDto;
import com.pickme.beeze.ceo.dto.ProductDto;
import com.pickme.beeze.ceo.dto.PurchaseDto;
import com.pickme.beeze.ceo.dto.PurchaseProductDto;
import com.pickme.beeze.ceo.dto.SalesChartDto;

import com.pickme.beeze.ceo.service.CeoService;
import com.pickme.beeze.ceo.dto.OrderDto;
import com.pickme.beeze.ceo.dto.PostDto;
import com.pickme.beeze.util.InfoUtil;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

		  System.out.println(dto);
		  
	     return service.getCeoInfo(dto);
   }
   
   
   //   발주목록
   @GetMapping("/polist")
   public Map<String, Object> polist(CeoParam param, Authentication Authentication, HttpServletRequest request) {
      System.out.println("CeoController polist " + new Date());
      
      int id = InfoUtil.getUserIdInfo(Authentication, request);
      param.setId(id);
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
   
   // 발주하기(최종)
   @PostMapping("/powritefinal")
   public String powritefinal(@RequestBody List<PurchaseProductDto> list, Authentication Authentication, HttpServletRequest request) {
	   System.out.println("powritefinal " + new Date());
	   
	   int id = InfoUtil.getUserIdInfo(Authentication, request);
	   for(PurchaseProductDto dto : list) {
	        dto.setId(id);
	    }
	   
	   System.out.println(list.toString());
	   boolean isS = service.powritefinal(list);
	   
	   if(isS) {
		   return "YES";
	   }else {
		   return "NO";
	   }	   
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
	public int deleteProduct(PurchaseDto dto) { // 여기를 productDto가 아니라 purchaseDto로 바꿨어요! // 왜냐면 Polist 자체가 PurchaseDto를 result로 가져오기 때문이에요
		System.out.println("BbsController deleteProduct " + new Date());
		
		// purchase_order
		service.deleteProduct(dto);
		
		// store_product 
		InventoryDto dto2 = new InventoryDto();
		


		dto2.setProductId(dto.getProductId());
		dto2.setStoreId(dto.getStoreId());
		dto2.setQuantity(dto.getQuantity());
		dto2.setExpDate(dto.getExpDate());
		return service.addProduct(dto2);
	
   }
	
	// 전체 주문 차트 보기
	
	@GetMapping("/saleschart")
	public List<SalesChartDto> saleschart(OrderDto dto) {
		
		System.out.println("salechartController salechart " + new Date());
		
		System.out.println("salechart :" + dto.toString());
		
		List<SalesChartDto> list = service.saleschart(dto);
		System.out.println("SaleChartDto :" + list.toString());
		
		return list;
	}
	
	// 재고
	@GetMapping("/inventory")
	public Map<String, Object> inventory(InventoryDto dto,Authentication Authentication, HttpServletRequest request) {
		System.out.println("invetoryController inventory " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);                                        
		dto.setId(id);
		System.out.println(dto.toString());
		
		List<InventoryDto> list = service.inventory(dto); 
		
	    // 발주 물품 총 수
        int count = service.getallinven(dto);
        int pageBbs = count / 10;
        if( (count % 10) > 0) {
           pageBbs = pageBbs + 1;
        }
        
        System.out.println(count);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("invenlist", list);
        map.put("pageBbs", pageBbs);
        map.put("cnt", count);
		  	  
	    return map;
	}
	
	// 픽업
	@GetMapping("/pickup")
	public Map<String, Object> pickup(Authentication Authentication, HttpServletRequest request,OrderDto dto) {
		System.out.println("pickupController pickup " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);                                            
		  dto.setId(id);

		  System.out.println(dto);
		  
	    List<OrderDto> list = service.pickup(dto);
	    
	    // 발주 물품 총 수
        int count = service.getallpickup(dto);
        int pageBbs = count / 10;
        if( (count % 10) > 0) {
           pageBbs = pageBbs + 1;
        }
        
        System.out.println(count);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pickuplist", list);
        map.put("pageBbs", pageBbs);
        map.put("cnt", count);
		  	  
	    return map;
	    
	}
	
	   // 픽업 승인완료 물품 사라지기
	   @PostMapping("/deletepickup")
		public void deletepickup(OrderDto dto) { 
			System.out.println("BbsController deletepickup " + new Date());
			
			System.out.println(dto.toString());

			service.deletepickup(dto);
	   }
	
	// 택배
	@GetMapping("/postcheck")
	public Map<String, Object> postcheck(Authentication Authentication, HttpServletRequest request, PostDto dto) {
		System.out.println("postcheckController postcheck " + new Date());
		
		int id = InfoUtil.getUserIdInfo(Authentication, request);                                          
		  dto.setId(id);

		  System.out.println(dto);
	     
		    List<PostDto> list = service.postcheck(dto);
		    
		    // 택배 총 수
	        int count = service.getallpost(dto);
	        int pageBbs = count / 10;
	        if( (count % 10) > 0) {
	           pageBbs = pageBbs + 1;
	        }
	        
	        System.out.println(count);
	        
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("postlist", list);
	        map.put("pageBbs", pageBbs);
	        map.put("cnt", count);
			  	  
		    return map;
	}
	
	   // 택배 승인완료 물품 사라지기
	   @PostMapping("/deletepost")
		public void deletepost(PostDto dto) { 
			System.out.println("BbsController deletepost " + new Date());
			
			System.out.println(dto.toString());

			service.deletepost(dto);
	   }

}