package com.pickme.beeze.manager.dto;

public class CcbParam {

	private String category;
	private int count;
	
	public CcbParam() {
		
	}

	public CcbParam(String category, int count) {
		super();
		this.category = category;
		this.count = count;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CcbParam [category=" + category + ", count=" + count + "]";
	}
	
}
