package com.pickme.beeze.review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.review.dto.ReviewDto;

@Mapper
@Repository
public interface ReviewDao {

	
	// 후기 목록
	List<ReviewDto> productReviewList(int id);
	
	// 상품 후기 작성 여부
	Map<String, Object> productReviewCheck(HashMap<String, Object> ids);
	
	//	후기 등록
	int reviewInsert(ReviewDto dto);
	
	//  후기 삭제
	int reviewDelete(HashMap<String, Object> ids);

	// 상품 평점 계산
	int productRatingAvg(int productId);
	
	// 상품 후기 수
	int productReviewCnt(int productId);

}
