package com.pickme.beeze.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pickme.beeze.login.dto.LoginDto;
import com.pickme.beeze.login.dto.OcrListDto;

@Mapper
@Repository
public interface LoginDao {

	/* 회원가입 */
	int addCustomerInfo(LoginDto dto);
	int addCeoInfo(LoginDto dto);
	
	/* 이메일(id) 중복확인 */
	int countCustomerInfo(String email);
	int countCeoInfo(String email);

	/* 로그인전 정보확인 */
	LoginDto whoCustomer(String email);
	LoginDto whoCeo(String email);
	
	/* 로그인 */
	LoginDto selectCustomerInfo(LoginDto dto);
	LoginDto selectCeoInfo(LoginDto dto);
	
	/* 아이디 찾기 */
	String findCustomerEmail(LoginDto dto);
	String findCeoEmail(LoginDto dto);
	
	/* 비밀번호 변경 */
	int changeCustomerPw(LoginDto dto);
	int changeCeoPw(LoginDto dto);
	
	/* 토큰값을 통한 회원확인 */
	LoginDto searchCustomerInfo(int id);
	LoginDto searchCeoInfo(int id);
	
	/* ocr url 넣기(관리자에 필요함) */
	void ocrurl(String fullUrl);
	List<OcrListDto> selectocrlist(OcrListDto dto);
	OcrListDto ocrlistdetail(int id);
	int ocrapproval(int id);
	int notocrcount(OcrListDto dto);
	
	/* 회원탈퇴 */
	void deleteCustomer(int id);
	
}
