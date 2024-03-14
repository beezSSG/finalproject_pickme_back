package com.pickme.beeze.product.dto;

public class ProductParam {

	private String search;
	private int pageNumber;
	
	public ProductParam() {
	}

	public ProductParam(String search, int pageNumber) {
		super();
		this.search = search;
		this.pageNumber = pageNumber;
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
		return "ProductParam [search=" + search + ", pageNumber=" + pageNumber + "]";
	}
	
	

}
