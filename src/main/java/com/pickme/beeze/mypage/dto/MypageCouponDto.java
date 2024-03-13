package com.pickme.beeze.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MypageCouponDto {

	private int id;
	private String content;
	private String startDate;
	private String endDate;
}
