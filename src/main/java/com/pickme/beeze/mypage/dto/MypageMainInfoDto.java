package com.pickme.beeze.mypage.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MyInfoDto")
public class MypageMainInfoDto {
	private int id;
	private String name;
	private int point;
	private int grade;
	private int cartQuantity;
	private int couponQuantity;
	private int saveQuantity;
	private int giftQuantity;
}
