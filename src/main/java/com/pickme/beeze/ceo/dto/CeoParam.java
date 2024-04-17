package com.pickme.beeze.ceo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CeoParam{
	
	private String choice;	// 카테고리
	private String search;	// 서치 내용
	private int pageNumber; // 페이지
	private int id;			// 점주ID

}
