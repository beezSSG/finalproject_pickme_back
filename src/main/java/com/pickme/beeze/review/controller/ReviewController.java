package com.pickme.beeze.review.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.review.dto.ReviewDto;
import com.pickme.beeze.review.service.ReviewService;
import com.pickme.beeze.util.InfoUtil;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1/review/*")
public class ReviewController {

	@Autowired
	ReviewService service;
	
	// 후기 목록
	@GetMapping("/productReviewList")
	public List<ReviewDto> productReviewtList(int id) {
		System.out.println("ReviewController productReviewtList " + new Date());
	
		return service.productReviewtList(id);
	}
	
	// 후기 등록
	@GetMapping("/reviewInsert")
	public String reviewInsert(ReviewDto dto, Authentication Authentication, HttpServletRequest request) {
		System.out.println("ReviewController reviewInsert " + new Date());
		
		int customerId = InfoUtil.getUserIdInfo(Authentication, request);
		dto.setCustomerId(customerId);
		
		boolean isS = service.reviewInsert(dto);
			    
	    if (isS) {
	        return "YES";
	    } else {
	        return "NO";
	    }
	}
	
	// 상품 평점 업데이트 후, 후기 수 반환
	@GetMapping("/productRatingAvg")
	public int productRatingAvg(int productId) {
		System.out.println("ReviewController productRatingAvg " + new Date());
		
		service.productRatingAvg(productId);
		return service.productReviewCnt(productId);
	}
	
	
	
}
