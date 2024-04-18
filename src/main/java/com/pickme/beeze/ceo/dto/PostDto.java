package com.pickme.beeze.ceo.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Alias("PostDto")
	public class PostDto {
		
		   private int id;
		   private int customerId;
		   private int ceoId;
		   private String customerName;
		   private String toUser;
		   private String toPhone;
		   private String toAddress;
		   private String reservationName;
		   private String reservationPassword;
		   private int itemPrice;
		   private String itemWeight;
		   private String itemCategory;
		   private String importantInfo;
		   private int totalPrice;
		   private String date;
		   private int postYn;
		   private int checkYn;
			private String search;
			private int pageNumber; // 페이지
}
