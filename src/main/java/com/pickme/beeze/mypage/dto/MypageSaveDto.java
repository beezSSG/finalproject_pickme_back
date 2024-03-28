package com.pickme.beeze.mypage.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MypageSaveDto")
public class MypageSaveDto {
	private int id;
	private String name;
	private int price;
	private String url;
	private int productRating;
}
