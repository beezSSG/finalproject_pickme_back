package com.pickme.beeze.product.dto;

import org.apache.ibatis.type.Alias;


public class ProductDto {

	private int id;
	private String name;
	private int price;
	private String url;
	private int productRating;
	private int categoryId;
	
	public ProductDto() {		
	}

	public ProductDto(int id, String name, int price, String url, int productRating, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.url = url;
		this.productRating = productRating;
		this.categoryId = categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + ", url=" + url + ", productRating="
				+ productRating + ", categoryId=" + categoryId + "]";
	}
	
	

}
