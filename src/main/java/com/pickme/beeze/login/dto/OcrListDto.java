package com.pickme.beeze.login.dto;

public class OcrListDto {

	private int id;
	private String url;
	private String ocrYn;
	private String storeName;
	private String date;
	private String enterNumber;
	
	public OcrListDto() {
		
	}

	public OcrListDto(int id, String url, String ocrYn, String storeName, String date, String enterNumber) {
		super();
		this.id = id;
		this.url = url;
		this.ocrYn = ocrYn;
		this.storeName = storeName;
		this.date = date;
		this.enterNumber = enterNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOcrYn() {
		return ocrYn;
	}

	public void setOcrYn(String ocrYn) {
		this.ocrYn = ocrYn;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEnterNumber() {
		return enterNumber;
	}

	public void setEnterNumber(String enterNumber) {
		this.enterNumber = enterNumber;
	}

	@Override
	public String toString() {
		return "OcrListDto [id=" + id + ", url=" + url + ", ocrYn=" + ocrYn + ", storeName=" + storeName + ", date="
				+ date + ", enterNumber=" + enterNumber + "]";
	}
	
}
