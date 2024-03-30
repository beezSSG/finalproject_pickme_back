package com.pickme.beeze.mypage.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MypageProductDto")
public class MypageProductDto {
	
	private int id;
	private String name;
	private int price;
	private String url;
	private int productRating; 
}
