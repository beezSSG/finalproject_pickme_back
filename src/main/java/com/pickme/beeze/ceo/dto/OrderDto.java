package com.pickme.beeze.ceo.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("OrderDto")
public class OrderDto {
	
	private int id;
	private int cartId;
	private String storeName;
	private String productName;
	private String customerName;
	private String date;
	private String address;
	private int cancelYn;
	private int pickDel;

}

