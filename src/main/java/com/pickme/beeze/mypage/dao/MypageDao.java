package com.pickme.beeze.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.mypage.dto.MypageCartDto;
import com.pickme.beeze.mypage.dto.MypageCouponDto;
import com.pickme.beeze.mypage.dto.MypageCustomerDto;
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
	
	/* TODO 장바구니 */
	// 장바구니 목록 불러오기
	List<MypageCartDto> getCart();
	// 장바구니 물품 삭제
	void delCart(MypageCartDto dto);
		
	/* TODO 개인정보 */
	// 개인정보 보기
	MypageCustomerDto getUserInfo();
	// 개인정보 수정
	void updateUserInfo(MypageCustomerDto dto);
	
	/* TODO 포인트 및 쿠폰 */
	// 내 포인트 적립/차감 하기
	void updatePoint(MypageCustomerDto dto);
	// 내 쿠폰 보기 (쿠폰은 한개 이상일 수 있으니까)
	List<MypageCouponDto> getCoupon(MypageCouponDto dto);

	
}
