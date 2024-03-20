package com.pickme.beeze.store.dto;

public class StoreProductDto {

	private int id;
	private int store_id;
	private int product_id;
	private int quantity;
	private String exp_date;
	
	public StoreProductDto() {	
	}

	public StoreProductDto(int id, int store_id, int product_id, int quantity, String exp_date) {
		super();
		this.id = id;
		this.store_id = store_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.exp_date = exp_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	@Override
	public String toString() {
		return "StoreProductDto [id=" + id + ", store_id=" + store_id + ", product_id=" + product_id + ", quantity="
				+ quantity + ", exp_date=" + exp_date + "]";
	}
	
	
	
}
