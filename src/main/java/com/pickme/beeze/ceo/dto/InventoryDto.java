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
		private int productId;
		private int quantity;
		private String expDate;
		private int price;
		private String storeName;
		private String productName;
		private String search;
		private int pageNumber; // 페이지
}
