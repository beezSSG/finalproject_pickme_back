package com.pickme.beeze.product.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ProductGiftDto")
public class ProductGiftDto {
	
	private int id;
	private int customerId;
	private int sendCustomerId;
	private int productId;
	private String expDay;
	private int useYn;
	private String giftUserName;
	private String productName;
	private String productUrl;
	
}
