package com.pickme.beeze.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.review.dao.ReviewDao;
import com.pickme.beeze.review.dto.ReviewDto;

@Service
@Transactional
public class ReviewService {

	@Autowired
	ReviewDao dao;
	
	
	// 후기 목록
	public List<ReviewDto> productReviewtList(int id){
		return dao.productReviewList(id);
	}	

	//	후기 등록
	public boolean reviewInsert(ReviewDto dto) {
		return dao.reviewInsert(dto)>0?true:false;
	}

	// 상품 평점 계산
	public boolean productRatingAvg(int productId) {
		return dao.productRatingAvg(productId)>0?true:false;
	}

	// 상품 후기 수
	public int productReviewCnt(int productId) {
		return dao.productReviewCnt(productId);
	}
}
