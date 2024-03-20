package com.pickme.beeze.product.dto;

public class ProductReview {
	
	private int id;
	private int productId;
	private int customerId;
	private String content;
	private int rating;
	
	public ProductReview() {
	}

	public ProductReview(int id, int productId, int customerId, String content, int rating) {
		super();
		this.id = id;
		this.productId = productId;
		this.customerId = customerId;
		this.content = content;
		this.rating = rating;
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

	@Override
	public String toString() {
		return "ProductReview [id=" + id + ", productId=" + productId + ", customerId=" + customerId + ", content="
				+ content + ", rating=" + rating + "]";
	}


}
