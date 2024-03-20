package com.pickme.beeze.product.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pickme.beeze.manager.service.CcbService;
import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductParam;
import com.pickme.beeze.product.dto.ProductReview;
import com.pickme.beeze.product.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/v1/product/*")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	// 전체 상품 목록
	@GetMapping("/productlist")
	public Map<String, Object> productlist(ProductParam param){
		System.out.println("ProductController productlist " + new Date());
		System.out.println(param.toString());
				
		// 글목록
		List<ProductDto> productlist = service.productlist(param);
		
		
		// 글의 총갯수
		int count = service.getallproduct(param);
		int pageBbs = count / 5;
		if((count % 5) > 0) {
			pageBbs = pageBbs + 1;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productlist", productlist);
		map.put("pageBbs", pageBbs);
		map.put("cnt", count);
		
		return map;		
	}
	
	// 상품 상세보기
	@GetMapping("/productdetail")
	public ProductDto productdetail(int id) {
		System.out.println("ProductController productdetail" + new Date());
	
		
		return service.productdetail(id);
	}
	
	
	// 신제품 등록
	@PostMapping("/newproductinsert")
	public String newproductinsert(ProductDto dto, 
	                        @RequestParam(value = "uploadfile", required = false) MultipartFile uploadfile,
	                        HttpServletRequest request) {

	    System.out.println("ProductController newproductinsert " + new Date());
	    
	    // 파일 업로드 경로를 static 폴더로 변경
	    String staticPath = "src/main/resources/static/upload";
	    
	    // 파일명을 변경하여 파일을 static 폴더에 저장
	    String filename = uploadfile.getOriginalFilename();
	    String newfilename = getNewFileName(filename);
	    String filepath = staticPath + "/" + newfilename;
	    System.out.println(filepath);
	    
	    // 파일 저장
	    try {
	        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(filepath));
	        os.write(uploadfile.getBytes()); // 파일 업로드
	        os.close();
	    } catch (FileNotFoundException e) {            
	        e.printStackTrace();
	    } catch (IOException e) {            
	        e.printStackTrace();
	    }
	    
	    // 데이터베이스에 전체 URL 저장
	    String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
	    String fullUrl = baseUrl + "/upload/" + newfilename; // 전체 URL 생성
	    dto.setUrl(fullUrl);
	    boolean isS = service.newproductinsert(dto);
	    
	    if (isS) {
	        return "YES";
	    } else {
	        return "NO";
	    }
	}

	private static String getNewFileName(String filename) {
		String newfilename = "";
		String fpost = "";	// .jpg .txt 등 확장자명을 끄집어냄
		
		if(filename.indexOf('.') >= 0) {	// 확장자명이 있음
			fpost = filename.substring(filename.indexOf('.'));	// .txt
			newfilename = new Date().getTime() + fpost;	// 43534534.txt
		}else {
			newfilename = new Date().getTime() + ".back";
		}
		
		return newfilename;
	}
	
	

	
	// 후기 목록
	@GetMapping("/productReviewList")
	public List<ProductReview> productReviewtList(int id) {
		System.out.println("ProductController productReviewtList " + new Date());
	
		return service.productReviewtList(id);
	}
	

}
