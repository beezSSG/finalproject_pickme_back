package com.pickme.beeze.manager.dto;

public class OrderDto {

	private int id;
	private int cartId;
	private String date;
	private String address;
	private int cancelYn;
	
	public OrderDto() {
		
	}

	public OrderDto(int id, int cartId, String date, String address, int cancelYn) {
		super();
		this.id = id;
		this.cartId = cartId;
		this.date = date;
		this.address = address;
		this.cancelYn = cancelYn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCancelYn() {
		return cancelYn;
	}

	public void setCancelYn(int cancelYn) {
		this.cancelYn = cancelYn;
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", cartId=" + cartId + ", date=" + date + ", address=" + address + ", cancelYn="
				+ cancelYn + "]";
	}
	
}
