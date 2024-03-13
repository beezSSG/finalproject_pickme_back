package com.pickme.beeze.mypage.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.mypage.dto.MypageCartDto;
import com.pickme.beeze.mypage.dto.MypageReviewDto;
import com.pickme.beeze.mypage.dto.MypageSaveDto;
import com.pickme.beeze.mypage.service.MypageService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/mypage/*")
public class MypageController {
	
	@Autowired
	MypageService service;
	
	// TODO 찜
	// 찜 생성
	@PostMapping("/save/addSave")
	public int addSave(MypageSaveDto dto) {	// 유저 토큰이 들어와야함
		System.out.println("MypageController addSave " + new Date());
		
		System.out.println(dto.toString());
		// 유저정보 받아오기
		
		// 제품정보 받아오기
		
		// 받아온 정보로 dto 생성
		
		return service.addSave(dto);
	}
	
	// 찜목록 불러오기
	@GetMapping("/save/getSave")
	public List<MypageSaveDto> getSave() {
		System.out.println("MypageController getSave " + new Date());
		
		return service.getSave();
	}
	
	// 찜 삭제
	@DeleteMapping("/save/delSave")
	public int delSave(MypageSaveDto dto) {
		System.out.println("MypageController delSave " + new Date());
		
	    return service.delSave(dto);
	}
	
	// TODO 리뷰
	// 리뷰 생성
	@PostMapping("/review/addReview")
	public int addReview(MypageReviewDto dto) {	// 유저 토큰이 들어와야함
		System.out.println("MypageController addReview " + new Date());
		
		System.out.println(dto.toString());
		// 유저정보 받아오기
		
		// 제품정보 받아오기
		
		// 받아온 정보로 dto 생성
		
		return service.addReview(dto);
	}
	
	// 리뷰 목록 불러오기
	@GetMapping("/review/getReview")
	public List<MypageReviewDto> getReview(MypageReviewDto dto) {
		System.out.println("MypageController getReview " + new Date());
		
		return service.getReview(dto);
	}
	
	// 리뷰 삭제
	@DeleteMapping("/review/delReview")
	public int delReview(MypageReviewDto dto) {
		System.out.println("MypageController delReview " + new Date());
		
	    return service.delReview(dto);
	}

	// TODO 장바구니	
	// 장바구니 목록 불러오기
	@GetMapping("/cart/getCart")
	public List<MypageCartDto> getCart() {
		System.out.println("MypageController getCart " + new Date());
		
		return service.getCart();
	}
	
	// 장바구니 삭제
	@DeleteMapping("/cart/delCart")
	public List<MypageCartDto> delCart(MypageCartDto dto) {
		System.out.println("MypageController delCart " + new Date());
		
		// 장바구니 삭제
		service.delCart(dto);
		
		// 삭제 진행이 완료된 장바구니 목록 불러와서 리턴		
	    return service.getCart();
	}
}
