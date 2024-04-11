package com.pickme.beeze.login.dto;

public class OcrListDto {

	private int id;
	private String url;
	private int ocrYn;

	public OcrListDto() {
		
	}

	public OcrListDto(int id, String url, int ocrYn) {
		super();
		this.id = id;
		this.url = url;
		this.ocrYn = ocrYn;
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

	public int getOcrYn() {
		return ocrYn;
	}

	public void setOcrYn(int ocrYn) {
		this.ocrYn = ocrYn;
	}

	@Override
	public String toString() {
		return "OcrListDto [id=" + id + ", url=" + url + ", ocrYn=" + ocrYn + "]";
	}
	
}
