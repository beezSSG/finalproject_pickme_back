package com.pickme.beeze.customer.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("CartDto")
public class CartDto {

	private int id;
	private int customerId;
	private int sProductId;
	private int orederYn;
	private int quantity;
	private int productId;
	private int productPrice;
	private String productUrl;
	private int pickDel;
}
