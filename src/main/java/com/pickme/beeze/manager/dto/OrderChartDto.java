package com.pickme.beeze.manager.dto;

public class OrderChartDto {
	
	private int orderId;
	private int cartId;
	private int customerId;
	private String productName;
	private String expDate;
	private int unitPrice;
	private int orderQuantity;
	private int totalPrice;
	private String storeName;
	
	public OrderChartDto() {
		
	}

	public OrderChartDto(int orderId, int cartId, int customerId, String productName, String expDate, int unitPrice,
			int orderQuantity, int totalPrice, String storeName) {
		super();
		this.orderId = orderId;
		this.cartId = cartId;
		this.customerId = customerId;
		this.productName = productName;
		this.expDate = expDate;
		this.unitPrice = unitPrice;
		this.orderQuantity = orderQuantity;
		this.totalPrice = totalPrice;
		this.storeName = storeName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public String toString() {
		return "OrderChartDto [orderId=" + orderId + ", cartId=" + cartId + ", customerId=" + customerId
				+ ", productName=" + productName + ", expDate=" + expDate + ", unitPrice=" + unitPrice
				+ ", orderQuantity=" + orderQuantity + ", totalPrice=" + totalPrice + ", storeName=" + storeName + "]";
	}
	
	
}
