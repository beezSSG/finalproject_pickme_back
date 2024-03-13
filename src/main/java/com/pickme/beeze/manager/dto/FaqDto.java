package com.pickme.beeze.manager.dto;

public class FaqDto {

	private int id;
	private String title;
	private String content;
	private int del; // 0: 삭제 전, 1: 삭제 후
	
	public FaqDto() {
		
	}

	public FaqDto(int id, String title, String content, int del) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.del = del;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	@Override
	public String toString() {
		return "FaqDto [id=" + id + ", title=" + title + ", content=" + content + ", del=" + del + "]";
	}
	
	
}
