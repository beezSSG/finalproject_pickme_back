package com.pickme.beeze.manager.dto;

public class FaqParam {

	private String choice;
	
	public FaqParam() {
		
	}

	public FaqParam(String choice) {
		super();
		this.choice = choice;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	@Override
	public String toString() {
		return "FaqParam [choice=" + choice + "]";
	}
	
	
}
