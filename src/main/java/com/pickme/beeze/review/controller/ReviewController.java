package com.pickme.beeze.review.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.review.dto.ReviewDto;
import com.pickme.beeze.review.service.ReviewService;

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
}
