package com.pickme.beeze.ccb.dto;

public class CcbaDto {

	private int id;
	private int ccbId;
	private String managerId;
	private String content;
	private String createAt;
	
	public CcbaDto() {
		
	}

	public CcbaDto(int id, int ccbId, String managerId, String content, String createAt) {
		super();
		this.id = id;
		this.ccbId = ccbId;
		this.managerId = managerId;
		this.content = content;
		this.createAt = createAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCcbId() {
		return ccbId;
	}

	public void setCcbId(int ccbId) {
		this.ccbId = ccbId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
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

	@Override
	public String toString() {
		return "CcbaDto [id=" + id + ", ccbId=" + ccbId + ", managerId=" + managerId + ", content=" + content
				+ ", createAt=" + createAt + "]";
	}

	
	
	
}
