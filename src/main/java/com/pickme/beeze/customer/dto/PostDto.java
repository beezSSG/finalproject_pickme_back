package com.pickme.beeze.customer.dto;

import org.apache.ibatis.type.Alias;

@Alias("PostDto")
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
	
	public PostDto() {
		
	}

	public PostDto(int id, int customerId, String toUser, String toPhone, String toAddress, String reservationName,
			String reservationPassword, int itemPrice, String itemWeight, String itemCategory, String importantInfo,
			int totalPrice, String date, int pageNumber, int storeId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.toUser = toUser;
		this.toPhone = toPhone;
		this.toAddress = toAddress;
		this.reservationName = reservationName;
		this.reservationPassword = reservationPassword;
		this.itemPrice = itemPrice;
		this.itemWeight = itemWeight;
		this.itemCategory = itemCategory;
		this.importantInfo = importantInfo;
		this.totalPrice = totalPrice;
		this.date = date;
		PageNumber = pageNumber;
		this.storeId = storeId;
	}

	@Override
	public String toString() {
		return "PostDto [id=" + id + ", customerId=" + customerId + ", toUser=" + toUser + ", toPhone=" + toPhone
				+ ", toAddress=" + toAddress + ", reservationName=" + reservationName + ", reservationPassword="
				+ reservationPassword + ", itemPrice=" + itemPrice + ", itemWeight=" + itemWeight + ", itemCategory="
				+ itemCategory + ", importantInfo=" + importantInfo + ", totalPrice=" + totalPrice + ", date=" + date
				+ ", PageNumber=" + PageNumber + ", storeId=" + storeId + "]";
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

	public String getToPhone() {
		return toPhone;
	}

	public void setToPhone(String toPhone) {
		this.toPhone = toPhone;
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

	public String getReservationPassword() {
		return reservationPassword;
	}

	public void setReservationPassword(String reservationPassword) {
		this.reservationPassword = reservationPassword;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemWeight() {
		return itemWeight;
	}

	public void setItemWeight(String itemWeight) {
		this.itemWeight = itemWeight;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getImportantInfo() {
		return importantInfo;
	}

	public void setImportantInfo(String importantInfo) {
		this.importantInfo = importantInfo;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPageNumber() {
		return PageNumber;
	}

	public void setPageNumber(int pageNumber) {
		PageNumber = pageNumber;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


}
