package com.pickme.beeze.product.dto;

public class ProductDto {

	private int id;
	private String name;
	private int price;
	private String detail;
	private String url;
	
	public ProductDto() {
		
	}

	public ProductDto(int id, String name, int price, String detail, String url) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + ", url=" + url
				+ "]";
	}
	
	
	
	
}
