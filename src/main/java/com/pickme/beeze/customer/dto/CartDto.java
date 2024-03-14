package com.pickme.beeze.customer.dto;

public class CartDto {

	private int id;
	private int cutomerId;
	private int sProductId;
	private int orederYn;
	
	public CartDto() {
		
	}

	public CartDto(int id, int cutomerId, int sProductId, int orederYn) {
		super();
		this.id = id;
		this.cutomerId = cutomerId;
		this.sProductId = sProductId;
		this.orederYn = orederYn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(int cutomerId) {
		this.cutomerId = cutomerId;
	}

	public int getsProductId() {
		return sProductId;
	}

	public void setsProductId(int sProductId) {
		this.sProductId = sProductId;
	}

	public int getOrederYn() {
		return orederYn;
	}

	public void setOrederYn(int orederYn) {
		this.orederYn = orederYn;
	}

	@Override
	public String toString() {
		return "CartDto [id=" + id + ", cutomerId=" + cutomerId + ", sProductId=" + sProductId + ", orederYn="
				+ orederYn + "]";
	}
	
	
}
