package com.pickme.beeze.ccb.dto;

public class CcbDto {

	private int id;
	private String category;
	private String customerId;
	private String title;
	private String content;
	private String createAt;
	private int answerYn;	// 0:답변X , 1:답변O
	
	public CcbDto() {
		
	}

	public CcbDto(int id, String category, String customerId, String title, String content, String createAt,
			int answerYn) {
		super();
		this.id = id;
		this.category = category;
		this.customerId = customerId;
		this.title = title;
		this.content = content;
		this.createAt = createAt;
		this.answerYn = answerYn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public int getAnswerYn() {
		return answerYn;
	}

	public void setAnswerYn(int answerYn) {
		this.answerYn = answerYn;
	}

	@Override
	public String toString() {
		return "ccbDto [id=" + id + ", category=" + category + ", customerId=" + customerId + ", title=" + title
				+ ", content=" + content + ", createAt=" + createAt + ", answerYn=" + answerYn + "]";
	}

}
