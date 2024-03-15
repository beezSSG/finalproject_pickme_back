package com.pickme.beeze.customer.dto;

public class CartDto {

	private int id;
	private int customerId;
	private int sProductId;
	private int orederYn;
	private int quantity;
	
	public CartDto() {
		
	}

	public CartDto(int id, int customerId, int sProductId, int orederYn, int quantity) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.sProductId = sProductId;
		this.orederYn = orederYn;
		this.quantity = quantity;
	}

	public CartDto(int customerId, int sProductId, int quantity) {
		super();
		this.customerId = customerId;
		this.sProductId = sProductId;
		this.quantity = quantity;
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

	public int getsProductId() {
		return sProductId;
	}

	public void setsProductId(int sProductId) {
		this.sProductId = sProductId;
	}

	public int getOrederYn() {
		return orederYn;
	}

	public void setOrederYn(int orederYn) {
		this.orederYn = orederYn;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartDto [id=" + id + ", customerId=" + customerId + ", sProductId=" + sProductId + ", orederYn="
				+ orederYn + ", quantity=" + quantity + "]";
	}

	

}
