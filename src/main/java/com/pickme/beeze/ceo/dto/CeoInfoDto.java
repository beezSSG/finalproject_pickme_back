package com.pickme.beeze.ceo.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CeoInfoDto {
	private int id;
	private String name;	// 점주 이름

}
