package com.pickme.beeze.login.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {	// 테스트용 비활성
	
	private int id;
	private String email;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private int point;
	private int grade;
	private String rdate;
	private int role;	// 0:고객 1:점주 2:관리자 이부분은 로그인 DB확인후 따로 주입하게 설정
}
