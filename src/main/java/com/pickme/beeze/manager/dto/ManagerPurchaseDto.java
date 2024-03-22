package com.pickme.beeze.manager.dto;

public class ManagerPurchaseDto {

	private int id;
	private int ceoId;	// 점주 id
	private int productId;	// 상품 id
	private int quantity;	// 수량
	private int poYn;
	private String storeName;
	private String wdate;
	private String startDate;
	private String endDate;
	private int pageNumber;
	
	public ManagerPurchaseDto() {
		
	}

	public ManagerPurchaseDto(int id, int ceoId, int productId, int quantity, int poYn, String storeName, String wdate,
			String startDate, String endDate, int pageNumber) {
		super();
		this.id = id;
		this.ceoId = ceoId;
		this.productId = productId;
		this.quantity = quantity;
		this.poYn = poYn;
		this.storeName = storeName;
		this.wdate = wdate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pageNumber = pageNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCeoId() {
		return ceoId;
	}

	public void setCeoId(int ceoId) {
		this.ceoId = ceoId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPoYn() {
		return poYn;
	}

	public void setPoYn(int poYn) {
		this.poYn = poYn;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "ManagerPurchaseDto [id=" + id + ", ceoId=" + ceoId + ", productId=" + productId + ", quantity="
				+ quantity + ", poYn=" + poYn + ", storeName=" + storeName + ", wdate=" + wdate + ", startDate="
				+ startDate + ", endDate=" + endDate + ", pageNumber=" + pageNumber + "]";
	}
	
}
