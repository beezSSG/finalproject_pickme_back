package com.pickme.beeze.mypage.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MypageOrderdayDto")
public class MypageOrderdayDto {
	
	private String date;
	private int quantity;
	private int pQuantity;
	private String pName;
	private int price;
	private String sAddress;
	private String ceoName;
}
