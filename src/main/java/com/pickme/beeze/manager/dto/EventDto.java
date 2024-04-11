package com.pickme.beeze.manager.dto;

public class EventDto {
	
	private int id;
	private String bannerPhoto;
	private String detailPhoto;
	private String startDate;
	private String endDate;
	private int promotionYn; // 0:진행중 이벤트, 1:종료된 이벤트
	
	public EventDto() {
		
	}

	public EventDto(int id, String bannerPhoto, String detailPhoto, String startDate, String endDate, int promotionYn) {
		super();
		this.id = id;
		this.bannerPhoto = bannerPhoto;
		this.detailPhoto = detailPhoto;
		this.startDate = startDate;
		this.endDate = endDate;
		this.promotionYn = promotionYn;
	}
	
	

	public EventDto(String endDate) {
		super();
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBannerPhoto() {
		return bannerPhoto;
	}

	public void setBannerPhoto(String bannerPhoto) {
		this.bannerPhoto = bannerPhoto;
	}

	public String getDetailPhoto() {
		return detailPhoto;
	}

	public void setDetailPhoto(String detailPhoto) {
		this.detailPhoto = detailPhoto;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPromotionYn() {
		return promotionYn;
	}

	public void setPromotionYn(int promotionYn) {
		this.promotionYn = promotionYn;
	}

	@Override
	public String toString() {
		return "EventDto [id=" + id + ", bannerPhoto=" + bannerPhoto + ", detailPhoto=" + detailPhoto + ", startDate="
				+ startDate + ", endDate=" + endDate + ", promotionYn=" + promotionYn + "]";
	}
	
	
	

}
