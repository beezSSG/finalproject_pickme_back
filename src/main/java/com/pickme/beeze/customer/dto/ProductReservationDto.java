package com.pickme.beeze.customer.dto;

public class ProductReservationDto {

	private int id;
	private int productId;
	private int customerId;
	private int storeId;
	private int quantity;
	private int pickYn;
	private String productName;
	private int ceoId;
	private String storeName;
	private String customerName;
	private int pageNumber;
	private String date;
	
	public ProductReservationDto() {
		
	}

	public ProductReservationDto(int id, int productId, int customerId, int storeId, int quantity, int pickYn,
			String productName, int ceoId, String storeName, String customerName, int pageNumber, String date) {
		super();
		this.id = id;
		this.productId = productId;
		this.customerId = customerId;
		this.storeId = storeId;
		this.quantity = quantity;
		this.pickYn = pickYn;
		this.productName = productName;
		this.ceoId = ceoId;
		this.storeName = storeName;
		this.customerName = customerName;
		this.pageNumber = pageNumber;
		this.date = date;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCeoId() {
		return ceoId;
	}

	public void setCeoId(int ceoId) {
		this.ceoId = ceoId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ProductReservationDto [id=" + id + ", productId=" + productId + ", customerId=" + customerId
				+ ", storeId=" + storeId + ", quantity=" + quantity + ", pickYn=" + pickYn + ", productName="
				+ productName + ", ceoId=" + ceoId + ", storeName=" + storeName + ", customerName=" + customerName
				+ ", pageNumber=" + pageNumber + ", date=" + date + "]";
	}

}
