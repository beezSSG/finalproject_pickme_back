package com.pickme.beeze.ceo.dto;

import org.apache.ibatis.type.Alias;

import com.pickme.beeze.login.dto.LoginDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ProductDto")
public class ProductDto {

	private int id;
	private int categoryId;
	private String name;
	private String categoryName;
	private int price;
	private String url;
	
}
