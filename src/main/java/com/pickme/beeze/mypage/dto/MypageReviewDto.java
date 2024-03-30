package com.pickme.beeze.mypage.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MypageReviewDto")
public class MypageReviewDto {
	
	private int productId;
	private int customerId;
	private String url;
	private String name;
	private String content;
	private int rating;
	private int productRating;
}