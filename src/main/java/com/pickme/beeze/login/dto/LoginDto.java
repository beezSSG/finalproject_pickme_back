package com.pickme.beeze.login.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("LoginDto")
public class LoginDto {
	
	private int id;
	private String email;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private int point;
	private int grade;
	private String rdate;

}
