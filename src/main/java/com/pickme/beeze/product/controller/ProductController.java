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

import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductParam;
import com.pickme.beeze.product.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/v1/product/*")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	// 전체 상품 목록
	@GetMapping("/productlist")
	public Map<String, Object> bbslist(ProductParam param){
		System.out.println("ProductController productlist " + new Date());
		System.out.println(param.toString());
		
		
		// 글목록
		List<ProductDto> productlist = service.productlist(param);
		
		// 글의 총갯수
		int count = service.getallproduct(param);
		int pageBbs = count / 8;
		if((count % 8) > 0) {
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
	public String pdsupload(ProductDto dto, 
							@RequestParam(value = "uploadfile",required = false)
							MultipartFile uploadfile,
							HttpServletRequest request) {
		
		System.out.println("ProductController newproductinsert " + new Date());
		
		// 파일업로드 경로
		String path = request.getServletContext().getRealPath("/upload");
				
	    String filename = uploadfile.getOriginalFilename();
				
		// 파일명을 변경!
		String newfilename = getNewFileName(filename);
				
		String filepath = path + "/" + newfilename;
		System.out.println(filepath);
				
		File file = new File(filepath);
				
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file));
								
			os.write(uploadfile.getBytes());	// 실제 업로드 되는 부분
			os.close();
					
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		dto.setUrl(filepath);
		boolean isS = service.newproductinsert(dto);
		
		if(isS) {
			return "YES";
		}
		else {
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
	

}
