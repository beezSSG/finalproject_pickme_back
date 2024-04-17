package com.pickme.beeze.ceo.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@NoArgsConstructor
	@AllArgsConstructor  
	@Alias("InventoryDto")
	public class InventoryDto {
		
		private int id;
		private int storeId;
		private String storeName;
		private int productId;
		private String productName;
		private int price;
		private int quantity;
		private String expDate;
}
