package com.pickme.beeze.mypage.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MypageOrderDto")
public class MypageOrderDto {
	
	private int id;
	private int cartId;
	private int customerID;	// 사용자 id
	private String date;
	private int cancelYn;	// 0: 취소전 / 1: 취소후
	private int sProductId;
	private int quantity;
	private int storeId;
	private String expDate;
	private String name;
	private int price;
	private String storeName;
	private double lat;
	private double lon;
	private String tel;
}
