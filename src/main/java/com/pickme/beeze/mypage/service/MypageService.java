package com.pickme.beeze.mypage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pickme.beeze.manager.dto.CcbDto;
import com.pickme.beeze.mypage.dao.MypageDao;
import com.pickme.beeze.mypage.dto.MyPickBoxDto;
import com.pickme.beeze.mypage.dto.MypageCouponDto;
import com.pickme.beeze.mypage.dto.MypageCustomerDto;
import com.pickme.beeze.mypage.dto.MypageMainInfoDto;
import com.pickme.beeze.mypage.dto.MypageOrderDto;
import com.pickme.beeze.mypage.dto.MypageOrderdayDto;
import com.pickme.beeze.mypage.dto.MypageProductDto;
import com.pickme.beeze.mypage.dto.MypageReviewDto;
import com.pickme.beeze.mypage.dto.MypageSaveDto;

@Service
@Transactional
public class MypageService {
	
	@Autowired
	MypageDao dao;
	
	// 나의 정보 불러오기
	public MypageMainInfoDto getMyInfo(MypageMainInfoDto dto) {
		
		MypageMainInfoDto newDto = dao.getMyInfo(dto);
		newDto.setCartQuantity(dao.getMyInfoCart(dto));
		newDto.setGiftQuantity(dao.getMyInfoGift(dto));
		newDto.setCouponQuantity(dao.getMyInfoCoupon(dto));		

		return newDto;
	};
	// 최근본 상품 불러오기
	public MypageProductDto getRecentlyProduct(int id) {
		return dao.getRecentlyProduct(id);
	}
	
	/* TODO 찜 */
	// 찜목록 불러오기
	public List<MypageSaveDto> getSave(int id){
		return dao.getSave(id);
	}

	
	/* TODO 개인정보 */
	// 개인정보 보기
	public MypageCustomerDto getUserInfo(int id) {
		return dao.getUserInfo(id);
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
	public List<MypageCouponDto> getCoupon(int id) {
		return dao.getCoupon(id);
	}
	public void deleteCoupon(int id, int point, MypageCouponDto dto) {
		dto.setUserId(id);
		System.out.println(dto.toString());
		dao.deleteCoupon(dto);
		MypageCustomerDto dto2 = new MypageCustomerDto();
		dto2.setId(id);
		dto2.setPoint(point);
		dao.updatePoint(dto2);
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
	public 	List<MypageOrderdayDto> MyOrdersList(int id) {
		return dao.MyOrdersLists(id);
//		List<MypageOrderdayDto> list = new ArrayList<MypageOrderdayDto>(); 
//		List<MypageOrderdayDto> list2 = new ArrayList<MypageOrderdayDto>();
//		list2 = dao.MyOrdersList(id);
//		for (MypageOrderdayDto dto : list2) {
//			List<MypageOrderdayDto> list3 = new ArrayList<MypageOrderdayDto>();
//			list3 = dao.MyOrdersListName(dto.getDate());
//			MypageOrderdayDto dto2 = list3.get(0);
//			int number = 0;
//			for (MypageOrderdayDto dto3 : list3) {
//				number = number + dto3.getQuantity();
//			}
//			System.out.println(number);
//			dto.setPName(dto2.getPName());
//			dto.setQuantity(number);
//			list.add(dto);
//		}
//		return list;		
	}
	
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
	
	/* TODO 픽박스 불러오기 */
	public List<MyPickBoxDto> MyPickBox(int id) {
		return dao.MyPickBox(id);
	}
	
	// 리뷰목록 불러오기
	public List<MypageReviewDto> getMyReview(int id) {
		return dao.getMyReview(id);
	}
	
}
