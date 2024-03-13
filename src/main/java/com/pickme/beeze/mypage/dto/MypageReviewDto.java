package com.pickme.beeze.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MypageReviewDto {
	
	private int productId;
	private int customerId;
	private String content;
	private int rating;
}
