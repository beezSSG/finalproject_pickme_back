package com.pickme.beeze.login.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Alias("UserDto")
public class UserDto {	// 토큰 사용시 점주 및 회원 통합 dto
	
	private int id;
	private String email;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private int point;
	private int grade;
}
