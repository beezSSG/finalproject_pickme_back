package com.pickme.beeze.customer.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("PostDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	private int id;
	private int customerId;
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
	private int PageNumber;
	private int storeId;

	
	
}
