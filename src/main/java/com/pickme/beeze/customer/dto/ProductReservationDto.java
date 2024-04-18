package com.pickme.beeze.customer.dto;

public class ProductReservationDto {

	private int id;
	private int productId;
	private int customerId;
	private int storeId;
	private int quantity;
	private int pickYn;
	
	public ProductReservationDto() {
		
	}

	public ProductReservationDto(int id, int productId, int customerId, int storeId, int quantity, int pickYn) {
		super();
		this.id = id;
		this.productId = productId;
		this.customerId = customerId;
		this.storeId = storeId;
		this.quantity = quantity;
		this.pickYn = pickYn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPickYn() {
		return pickYn;
	}

	public void setPickYn(int pickYn) {
		this.pickYn = pickYn;
	}

	@Override
	public String toString() {
		return "ProductReservationDto [id=" + id + ", productId=" + productId + ", customerId=" + customerId
				+ ", storeId=" + storeId + ", quantity=" + quantity + ", pickYn=" + pickYn + "]";
	}
}
