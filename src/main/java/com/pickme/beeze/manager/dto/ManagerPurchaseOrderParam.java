package com.pickme.beeze.manager.dto;

public class ManagerPurchaseOrderParam {

	private int id;
	private String productUrl;
	private String productName;
	private String storeName;
	private int poYn;
	private String wdate;
	private int price;
	private int quantity;
	
	public ManagerPurchaseOrderParam() {
		
	}

	public ManagerPurchaseOrderParam(int id, String productUrl, String productName, String storeName, int poYn,
			String wdate, int price, int quantity) {
		super();
		this.id = id;
		this.productUrl = productUrl;
		this.productName = productName;
		this.storeName = storeName;
		this.poYn = poYn;
		this.wdate = wdate;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getPoYn() {
		return poYn;
	}

	public void setPoYn(int poYn) {
		this.poYn = poYn;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ManagerPurchaseOrderParam [id=" + id + ", productUrl=" + productUrl + ", productName=" + productName
				+ ", storeName=" + storeName + ", poYn=" + poYn + ", wdate=" + wdate + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}



}
