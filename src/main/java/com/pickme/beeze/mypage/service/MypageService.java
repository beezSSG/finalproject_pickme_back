package com.pickme.beeze.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.mypage.dao.MypageDao;
import com.pickme.beeze.mypage.dto.MypageCartDto;
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
}
