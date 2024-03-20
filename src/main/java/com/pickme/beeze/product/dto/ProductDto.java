package com.pickme.beeze.product.dto;

public class ProductDto {

	private int id;
	private String name;
	private int price;
	private String url;
	private int productRating;
	
	public ProductDto() {
		
	}

	public ProductDto(int id, String name, int price, String url, int productRating) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.url = url;
		this.productRating = productRating;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", url=" + url + ", productRating="
				+ productRating + "]";
	}
	
	

}
