package com.pickme.beeze.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MypageReviewDto {
	
	private int productId;
	private int customerId;
	private String content;
	private int rating;
}
