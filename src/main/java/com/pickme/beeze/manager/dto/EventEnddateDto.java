package com.pickme.beeze.manager.dto;

public class EventEnddateDto {

	private String endDate;
	
	public EventEnddateDto() {
		
	}

	public EventEnddateDto(String endDate) {
		super();
		this.endDate = endDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "EventEnddateDto [endDate=" + endDate + "]";
	}
	
}
