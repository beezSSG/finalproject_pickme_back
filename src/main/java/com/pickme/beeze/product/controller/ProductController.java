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
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pickme.beeze.manager.service.CcbService;
import com.pickme.beeze.product.dto.ProductDto;
import com.pickme.beeze.product.dto.ProductGiftDto;
import com.pickme.beeze.product.dto.ProductGiftParam;
import com.pickme.beeze.product.dto.ProductParam;
import com.pickme.beeze.product.service.ProductService;
import com.pickme.beeze.util.InfoUtil;
import com.pickme.beeze.util.S3Service;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/v1/product/*")
public class ProductController {
	
    private final S3Service s3Service;

    @Autowired
    public ProductController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

	
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
		int pageBbs = count / 9;
		if((count % 9) > 0) {
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
	
	
    @PostMapping("/newproductinsert")
    public String newproductinsert(ProductDto dto, 
                        @RequestParam(value = "uploadfile", required = false) MultipartFile uploadfile) {

        System.out.println("ProductController newproductinsert " + new Date());
        
        try {
            // Amazon S3를 통해 파일 업로드
            String s3FileUrl = s3Service.uploadFile("mypickmebuket", uploadfile.getOriginalFilename(), uploadfile);
            
            // 데이터베이스에 Amazon S3 URL 저장
            dto.setUrl(s3FileUrl);
            boolean isS = service.newproductinsert(dto);
            
            if (isS) {
                return "YES";
            } else {
                return "NO";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "NO"; // 업로드 실패 시 NO 반환
        }
    }


	
	/* 선물함기능 */
	// 선물 보내기
	@PostMapping("/sendGift")
	public void sendGift(ProductGiftDto dto, Authentication Authentication, HttpServletRequest request) {
	    System.out.println("ProductController sendGift " + new Date());
	    	    
	    int id = InfoUtil.getUserIdInfo(Authentication, request);
	    dto.setCustomerId(id);
	    
	    service.sendGift(dto);	    
	}
	
	// 받는 사람 조회
	@GetMapping("/findFromUser")
	public ProductGiftParam findFromUser(String phone) {
		System.out.println("ProductController findFromUser" + new Date());
		
		return service.findFromUser(phone);
	}	

	// 내 선물보기
	@GetMapping("/getMyGift")
	public List<ProductGiftDto> getMyGift(Authentication Authentication, HttpServletRequest request) {
		System.out.println("ProductController getMyGift " + new Date());
	
		int id = InfoUtil.getUserIdInfo(Authentication, request);
		System.out.println("userId " + id);
		
		return service.getMyGift(id);
	}
	
	// 선물 사용
	@PostMapping("/useGift")
	public void useGift(int id) {
	    System.out.println("ProductController useGift " + new Date());
	    
	    service.useGift(id);
	}

}
