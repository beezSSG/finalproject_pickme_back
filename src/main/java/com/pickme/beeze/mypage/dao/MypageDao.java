package com.pickme.beeze.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.mypage.dto.MypageCouponDto;
import com.pickme.beeze.mypage.dto.MypageCustomerDto;
import com.pickme.beeze.mypage.dto.MypageMainInfoDto;
import com.pickme.beeze.mypage.dto.MypageOrderDto;
import com.pickme.beeze.mypage.dto.MypageReviewDto;
import com.pickme.beeze.mypage.dto.MypageSaveDto;

@Mapper
@Repository
public interface MypageDao {
	
	// int를 최종리턴할때 0은 실패 0이상은 성공
	
	// 나의 정보 불러오기
	MypageMainInfoDto getMyInfo(MypageMainInfoDto dto);
	// int getMyInfoTwo(String email);
	
	/* TODO 찜 */
	// 찜목록 불러오기
	List<MypageSaveDto> getSave(int id);
		
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
	
	/* TODO 1:1 문의 게시판 */
	// 내 문의 작성하기
	int addCcbList(CcbDto dto);
	// 내 문의 모아보기
	List<CcbDto> getMyCcbList(CcbDto dto);

	/* TODO 주문내역 */
	// 내 주문 내역 불러오기
	List<MypageOrderDto> getMyOrderList(MypageOrderDto dto);
	MypageOrderDto getMYOrderProduct(MypageOrderDto dto);
	MypageOrderDto getMyOrderStore(MypageOrderDto dto);
	// 내 주문 내역 취소
	void cancelMyOrder(MypageOrderDto dto);
	
	

	// 여기서 부터 변경
	/* TODO 리뷰 */
	// 리뷰작성
	int addReview(MypageReviewDto dto);
	// 리뷰목록 불러오기
	List<MypageReviewDto> getReview(MypageReviewDto dto);
	// 리뷰삭제
	int delReview(MypageReviewDto dto);
	
}
