package com.pickme.beeze.review.dto;

public class ReviewDto {
	
	private int id;
	private int product_id;
	private int customer_id;
	private String content;
	private int rating;
	
	public ReviewDto() {		
	}

	public ReviewDto(int id, int product_id, int customer_id, String content, int rating) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.content = content;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
		return "ReviewDto [id=" + id + ", product_id=" + product_id + ", customer_id=" + customer_id + ", content="
				+ content + ", rating=" + rating + "]";
	}
	
	

}
