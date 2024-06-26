package com.pickme.beeze.ceo.dto;

public class PurchaseProductDto {

	private int id;
	private String name;
	private int price;
	private int quantity;
	
	public PurchaseProductDto() {
		
	}

	public PurchaseProductDto(int id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PurchaseProductDto [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

	
	
	
}
