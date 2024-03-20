package com.pickme.beeze.product.dto;

public class ProductParam {

	private String choice;
	private String search;
	private int pageNumber;
	private boolean switching;
	
	public ProductParam() {
	}

	public ProductParam(String choice, String search, int pageNumber, boolean switching) {
		super();
		this.choice = choice;
		this.search = search;
		this.pageNumber = pageNumber;
		this.switching = switching;
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

	public boolean isSwitching() {
		return switching;
	}

	public void setSwitching(boolean switching) {
		this.switching = switching;
	}

	@Override
	public String toString() {
		return "ProductParam [choice=" + choice + ", search=" + search + ", pageNumber=" + pageNumber + ", switching="
				+ switching + "]";

	}

}
