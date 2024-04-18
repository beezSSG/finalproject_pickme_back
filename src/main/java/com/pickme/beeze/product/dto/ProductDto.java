package com.pickme.beeze.product.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ProductDto")
public class ProductDto {

	private int id;
	private String name;
	private int price;
	private String url;
	private int productRating;
	private int categoryId;
	private int promotionType;
	private String expDate;
	private int sProductId;

}
