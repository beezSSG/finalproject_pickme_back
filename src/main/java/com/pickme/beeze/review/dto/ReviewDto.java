package com.pickme.beeze.review.dto;

public class ReviewDto {
	
	private int id;
	private int productId;
	private int customerId;
	private String content;
	private int rating;
	private String name;
	
	public ReviewDto() {		
	}

	public ReviewDto(int id, int productId, int customerId, String content, int rating, String name) {
		super();
		this.id = id;
		this.productId = productId;
		this.customerId = customerId;
		this.content = content;
		this.rating = rating;
		this.name = name;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ReviewDto [id=" + id + ", productId=" + productId + ", customerId=" + customerId + ", content="
				+ content + ", rating=" + rating + ", name=" + name + "]";
	}

	
	
	

}
