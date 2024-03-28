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
}
