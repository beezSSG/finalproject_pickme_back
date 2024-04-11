package com.pickme.beeze.product.dto;

public class ProductParam {

	private String choice;
	private String search;
	private int pageNumber;
	private boolean switching;
	private int category;
	
	// 무한 스크롤
	private int perPage;
	private int start;

	
	public ProductParam() {
	}


	public ProductParam(String choice, String search, int pageNumber, boolean switching, int category, int perPage,
			int start) {
		super();
		this.choice = choice;
		this.search = search;
		this.pageNumber = pageNumber;
		this.switching = switching;
		this.category = category;
		this.perPage = perPage;
		this.start = start;
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


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public int getPerPage() {
		return perPage;
	}


	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	@Override
	public String toString() {
		return "ProductParam [choice=" + choice + ", search=" + search + ", pageNumber=" + pageNumber + ", switching="
				+ switching + ", category=" + category + ", perPage=" + perPage + ", start=" + start + "]";
	}
	
	
	

}
