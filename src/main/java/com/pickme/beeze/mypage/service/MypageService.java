package com.pickme.beeze.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.mypage.dao.MypageDao;
import com.pickme.beeze.mypage.dto.MypageCouponDto;
import com.pickme.beeze.mypage.dto.MypageCustomerDto;
import com.pickme.beeze.mypage.dto.MypageMainInfoDto;
import com.pickme.beeze.mypage.dto.MypageOrderDto;
import com.pickme.beeze.mypage.dto.MypageReviewDto;
import com.pickme.beeze.mypage.dto.MypageSaveDto;

@Service
@Transactional
public class MypageService {
	
	@Autowired
	MypageDao dao;
	
	// 나의 정보 불러오기
	public MypageMainInfoDto getMyInfo(MypageMainInfoDto dto) {
		
		/*
		MypageMainInfoDto d = dao.getMyInfo(dto);
		int i = dao.getMyInfoTwo(email);
		d.setSaveQuantity(i);
		return d;
		*/
		return dao.getMyInfo(dto);
	};
	
	/* TODO 찜 */
	// 찜목록 불러오기
	public List<MypageSaveDto> getSave(int id){
		return dao.getSave(id);
	}

	
	/* TODO 개인정보 */
	// 개인정보 보기
	public MypageCustomerDto getUserInfo() {
		return dao.getUserInfo();
	}
	// 개인정보 수정
	public void updateUserInfo(MypageCustomerDto dto) {
		dao.updateUserInfo(dto);
	}
	
	/* TODO 포인트 및 쿠폰 */
	// 내 포인트 적립/차감 하기
	public void updatePoint(MypageCustomerDto dto) {
		dao.updatePoint(dto);
	}
	// 내 쿠폰 보기 (쿠폰은 한개 이상일 수 있으니까)
	public List<MypageCouponDto> getCoupon(MypageCouponDto dto) {
		return dao.getCoupon(dto);
	}
	
	/* TODO 1:1 문의 게시판 */
	// 내 문의 작성하기
	public int addCcbList(CcbDto dto) {
		return dao.addCcbList(dto);
	}
	// 내 문의 모아보기
	public List<CcbDto> getMyCcbList(CcbDto dto){
		return dao.getMyCcbList(dto);
	}
	
	/* TODO 주문내역 */
	// 내 주문 내역 불러오기
	public List<MypageOrderDto> getMyOrderList(MypageOrderDto dto) {
		List<MypageOrderDto> list = dao.getMyOrderList(dto);
	
		// list의 각 dto에 정보를 전부 주입하는 과정
		for (MypageOrderDto mydto : list) {
			dao.getMYOrderProduct(mydto);
			dao.getMyOrderStore(mydto);
		}
		
		return list;		
	}
	// 내 주문 내역 취소
	public void cancelMyOrder(MypageOrderDto dto) {
		dao.cancelMyOrder(dto);
	}
	
	
	
	// 여기서 부터 변경
	/* TODO 리뷰 */
	// 리뷰작성
	public int addReview(MypageReviewDto dto) {
		return dao.addReview(dto);
	}
	// 리뷰목록 불러오기
	public List<MypageReviewDto> getReview(MypageReviewDto dto) {
		return dao.getReview(dto);
	}
	// 리뷰삭제
	public int delReview(MypageReviewDto dto) {
		return dao.delReview(dto);
	}
	
}
