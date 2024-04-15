package com.pickme.beeze.store.dto;

import org.apache.ibatis.type.Alias;

import com.pickme.beeze.product.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("StoreProductDto")
public class StoreProductDto {

	private int id;
	private int store_id;
	private int product_id;
	private int quantity;
	private String exp_date;
	
}
