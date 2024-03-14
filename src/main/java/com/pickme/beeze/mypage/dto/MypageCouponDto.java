package com.pickme.beeze.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MypageCouponDto {

	private int id;
	private String content;
	private String startDate;
	private String endDate;
}
