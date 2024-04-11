package com.pickme.beeze.mypage.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MypageCouponDto")
public class MypageCouponDto {

	private int id;
	private String content;
	private String startDate;
	private String endDate;
	private int useYn;
}
