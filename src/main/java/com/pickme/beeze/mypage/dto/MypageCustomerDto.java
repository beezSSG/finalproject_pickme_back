package com.pickme.beeze.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MypageCustomerDto {
	
	private int id;
	private String email;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private int point;
	private String grade;
	private String rdate;
	
}
