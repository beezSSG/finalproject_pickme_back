package com.pickme.beeze.login.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("LoginDto")
public class LoginDto { // 토큰 사용시 점주 및 회원 통합 dto
	
	private int id;
	private String email;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private int point;
	private int grade;
	private String rdate;
	private String role;			// customer:고객 ceo:점주 manager:관리자 이부분은 로그인 DB확인후 따로 주입하게 설정
	private boolean loginSns;     //소셜로그인 여부 (default = false)

}
