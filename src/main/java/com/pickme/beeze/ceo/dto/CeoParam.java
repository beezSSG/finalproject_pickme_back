package com.pickme.beeze.ceo.dto;


public class CeoParam{
	
	private String choice;	// 카테고리
	private String search;	// 서치 내용
	private int pageNumber; // 페이지
	
	public CeoParam() {

	}

	public CeoParam(String choice, String search, int pageNumber) {
		super();
		this.choice = choice;
		this.search = search;
		this.pageNumber = pageNumber;
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
		return "CeoParam [choice=" + choice + ", search=" + search + ", pageNumber=" + pageNumber + "]";
	}
}
