package com.pickme.beeze.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.mypage.dao.MypageDao;
import com.pickme.beeze.mypage.dto.MypageCartDto;
import com.pickme.beeze.mypage.dto.MypageCouponDto;
import com.pickme.beeze.mypage.dto.MypageCustomerDto;
import com.pickme.beeze.mypage.dto.MypageReviewDto;
import com.pickme.beeze.mypage.dto.MypageSaveDto;

@Service
@Transactional
public class MypageService {
	
	@Autowired
	MypageDao dao;
	
	/* TODO 찜 */
	// 찜생성
	public int addSave(MypageSaveDto dto) {
		return dao.addSave(dto);
	}
	// 찜목록 불러오기
	public List<MypageSaveDto> getSave(){
		return dao.getSave();
	}
	// 찜삭제
	public int delSave(MypageSaveDto dto) {
		return dao.delSave(dto);
	}
	
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
	
	/* TODO 장바구니 */
	// 장바구니 목록 불러오기
	public List<MypageCartDto> getCart(){
		return dao.getCart();
	}
	// 장바구니 물품 삭제
	public void delCart(MypageCartDto dto) {
		dao.delCart(dto);
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
	
	
}
