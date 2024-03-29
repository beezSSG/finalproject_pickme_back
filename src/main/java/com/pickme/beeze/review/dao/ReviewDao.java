package com.pickme.beeze.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.review.dto.ReviewDto;

@Mapper
@Repository
public interface ReviewDao {

	
	// 후기 목록
	List<ReviewDto> productReviewList(int id);
	
	//	후기 등록
	
	

}
