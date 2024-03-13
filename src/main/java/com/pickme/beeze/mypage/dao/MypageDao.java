package com.pickme.beeze.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.mypage.dto.MypageReviewDto;
import com.pickme.beeze.mypage.dto.MypageSaveDto;

@Mapper
@Repository
public interface MypageDao {
	
	// int를 최종리턴할때 0은 실패 0이상은 성공
	
	/* TODO 찜 */
	// 찜생성
	int addSave(MypageSaveDto dto);
	// 찜목록 불러오기
	List<MypageSaveDto> getSave();
	// 찜삭제
	int delSave(MypageSaveDto dto);
	
	/* TODO 리뷰 */
	// 리뷰작성
	int addReview(MypageReviewDto dto);
	// 리뷰목록 불러오기
	List<MypageReviewDto> getReview(MypageReviewDto dto);
	// 리뷰삭제
	int delReview(MypageReviewDto dto);
}
