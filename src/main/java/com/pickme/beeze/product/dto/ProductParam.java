package com.pickme.beeze.product.dto;

public class ProductParam {

	private String choice;
	private String search;
	private int pageNumber;
	
	public ProductParam() {
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "ProductParam [choice=" + choice + ", search=" + search + ", pageNumber=" + pageNumber + "]";
	}

	
	

}
