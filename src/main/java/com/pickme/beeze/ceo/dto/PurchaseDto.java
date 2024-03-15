package com.pickme.beeze.ceo.dto;


public class PurchaseDto{
	private int id;
	private int ceoId;	// 점주 id
	private int productId;	// 상품 id
	private String url;		// 대표이미지
	private String name;	// 상품 네임
	private int quantity;	// 수량
	private int poYn;
	private String wdate;
	
	
	public PurchaseDto() {
	}


	public PurchaseDto(int id, int ceoId, int productId, String url, String name, int quantity, int poYn,
			String wdate) {
		super();
		this.id = id;
		this.ceoId = ceoId;
		this.productId = productId;
		this.url = url;
		this.name = name;
		this.quantity = quantity;
		this.poYn = poYn;
		this.wdate = wdate;
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


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getWdate() {
		return wdate;
	}


	public void setWdate(String wdate) {
		this.wdate = wdate;
	}


	@Override
	public String toString() {
		return "PurchaseDto [id=" + id + ", ceoId=" + ceoId + ", productId=" + productId + ", url=" + url + ", name="
				+ name + ", quantity=" + quantity + ", poYn=" + poYn + ", wdate=" + wdate + "]";
	}

}
