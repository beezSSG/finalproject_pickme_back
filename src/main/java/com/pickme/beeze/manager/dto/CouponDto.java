package com.pickme.beeze.manager.dto;

public class CouponDto {

	private int id;
	private int userId;
	private String content;
	private String startDate;
	private String endDate;
	private int couponNumber;
	
	public CouponDto() {
		
	}

	public CouponDto(int id, int userId, String content, String startDate, String endDate, int couponNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.couponNumber = couponNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getCouponNumber() {
		return couponNumber;
	}

	public void setCouponNumber(int couponNumber) {
		this.couponNumber = couponNumber;
	}

	@Override
	public String toString() {
		return "CouponDto [id=" + id + ", userId=" + userId + ", content=" + content + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", couponNumber=" + couponNumber + "]";
	}
	
}
