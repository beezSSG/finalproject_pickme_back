package com.pickme.beeze.mypage.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("MyPickBoxDto")
public class MyPickBoxDto {

	private String pName;
	private int quantity;
	private String pUrl;
	private String expDate;
	private String sName;
	private String date;
	private int pId;
}
