package com.pickme.beeze.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MypageCustomerDto {
	
	private int id;
	private String email;
	private String name;
	private String address;
	private String phone;
	private int point;
	private int grade;
	
}
