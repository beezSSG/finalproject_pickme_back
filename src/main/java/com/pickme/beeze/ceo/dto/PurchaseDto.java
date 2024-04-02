package com.pickme.beeze.ceo.dto;


import org.apache.ibatis.type.Alias;

import com.pickme.beeze.login.dto.LoginDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("PurchaseDto")
public class PurchaseDto {

	private int id;
	private int ceoId;	// 점주 id
	private int productId;	// 상품 id
	private String url;		// 대표이미지
	private String name;	// 상품 네임
	private int quantity;	// 수량
	private int poYn;
	private String wdate;
	private int del;

	
	
}

