package com.pickme.beeze.customer.dto;

import org.apache.ibatis.type.Alias;

@Alias("PostDto")
public class PostDto {

	private int id;
	private int customerId;
	private String toUser;
	private String toAddress;
	private String reservationName;
	private int itemPrice;
	private int itemWeight;
	
	public PostDto() {
		
	}

	public PostDto(int id, int customerId, String toUser, String toAddress, String reservationName, int itemPrice,
			int itemWeight) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.toUser = toUser;
		this.toAddress = toAddress;
		this.reservationName = reservationName;
		this.itemPrice = itemPrice;
		this.itemWeight = itemWeight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(int itemWeight) {
		this.itemWeight = itemWeight;
	}

	@Override
	public String toString() {
		return "PostDto [id=" + id + ", customerId=" + customerId + ", toUser=" + toUser + ", toAddress=" + toAddress
				+ ", reservationName=" + reservationName + ", itemPrice=" + itemPrice + ", itemWeight=" + itemWeight
				+ "]";
	}

}
