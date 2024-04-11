package com.pickme.beeze.ceo.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("PurchaseDto")
public class SaleChartDto {
	
		private int id;
		private int ceoId;				// 점주 id
		private int productId;			// 상품 id
		private String productName;		// 상품 네임
		private int orderQuantity;		// 수량
		private int totalPrice;
		private int unitPrice;
		private String expDate;
		private String storeName;		// 점포 이름
		
}
