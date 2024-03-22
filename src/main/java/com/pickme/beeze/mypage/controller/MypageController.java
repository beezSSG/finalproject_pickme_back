package com.pickme.beeze.mypage.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.mypage.dto.MypageCouponDto;
import com.pickme.beeze.mypage.dto.MypageCustomerDto;
import com.pickme.beeze.mypage.dto.MypageOrderDto;
import com.pickme.beeze.mypage.dto.MypageReviewDto;
import com.pickme.beeze.mypage.dto.MypageSaveDto;
import com.pickme.beeze.mypage.service.MypageService;
import com.pickme.beeze.util.NaverCloud;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




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
	
	// TODO 챗봇
	@PostMapping("/chatbot")
	public String chatbot(String voiceMessage) {
		System.out.println("NaverCloudController chatbot" + new Date());
		
		System.out.println("voiceMessage : " + voiceMessage);
		
		// 네이버 클라우드 불러오기
		NaverCloud nc = new NaverCloud();
		String chatbotMessage = nc.ChatBot(voiceMessage);
		
		return chatbotMessage;
	}
	
	// TODO 개인정보
	// 개인정보 보기
	@GetMapping("/user/getUserInfo")
	public MypageCustomerDto getUserInfo() {
		System.out.println("MypageController getUserInfo " + new Date());
		
		return service.getUserInfo();
	}
	
	// 개인정보 수정
	@PostMapping("/user/updateUserInfo")
	public void updateUserInfo(MypageCustomerDto dto) {
		System.out.println("MypageController updateUserInfo " + new Date());
		
		service.updateUserInfo(dto);
	}
	
	// TODO 포인트 및 쿠폰
	// 내 포인트 적립/차감 하기
	@GetMapping("/user/updatePoint")
	public void updatePoint(MypageCustomerDto dto) {
		System.out.println("MypageController updatePoint " + new Date());
		
		service.updatePoint(dto);
	}

	// 내 쿠폰 보기 (쿠폰은 한개 이상일 수 있으니까);
	@PostMapping("/user/getCoupon")
	public List<MypageCouponDto> getCoupon(MypageCouponDto dto) {
		System.out.println("MypageController getCoupon " + new Date());
		
		return service.getCoupon(dto);
	}
	
	// TODO 1:1 문의 게시판
	// 내 문의 작성하기
	@PostMapping("/addCcbList")
	public int addCcbList(CcbDto dto) {
		System.out.println("MypageController addCcbList " + new Date());
		
		return service.addCcbList(dto);
	}
	// 내 문의 모아보기
	@GetMapping("/getMyCcbList")
	public List<CcbDto> getMyCcbList(CcbDto dto){
		System.out.println("MypageController getMyCcbList " + new Date());
		
		return service.getMyCcbList(dto);
	}
	
	// TODO 주문내역
	// 내 주문내역 보기
	@GetMapping("/getMyOrderList")
	public List<MypageOrderDto> getMyOrderList(MypageOrderDto dto) {
		System.out.println("MypageController getMyOrderList " + new Date());
		
		return service.getMyOrderList(dto);
	}
	
	// 내 주문 취소
	@PutMapping("/cancelMyOrder")
	public void cancelMyOrder(MypageOrderDto dto) {
		System.out.println("MypageController cancelMyOrder " + new Date());
		
		service.cancelMyOrder(dto);
	}
	
	/* 여기서 부터는 합칠것 */
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
	
}
