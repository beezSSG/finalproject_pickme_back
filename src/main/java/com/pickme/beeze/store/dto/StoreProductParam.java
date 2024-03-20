package com.pickme.beeze.store.dto;

public class StoreProductParam {
	
	private String choice;
	private String search;
	private int pageNumber;
	private int store_id;
	private boolean switching;
	
	public StoreProductParam() {
	}

	public StoreProductParam(String choice, String search, int pageNumber, int store_id, boolean switching) {
		super();
		this.choice = choice;
		this.search = search;
		this.pageNumber = pageNumber;
		this.store_id = store_id;
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

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public boolean isSwitching() {
		return switching;
	}

	public void setSwitching(boolean switching) {
		this.switching = switching;
	}

	@Override
	public String toString() {
		return "StoreProductParam [choice=" + choice + ", search=" + search + ", pageNumber=" + pageNumber
				+ ", store_id=" + store_id + ", switching=" + switching + "]";
	}

	

}
