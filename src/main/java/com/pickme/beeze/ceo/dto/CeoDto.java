package com.pickme.beeze.ceo.dto;


public class CeoDto{
	
	private int id;
	private String email;
	private String pw;
	private String name;
	private String phone;
	private String address;
	
	public CeoDto() {
	}

	public CeoDto(int id, String email, String pw, String name, String phone, String address) {
		super();
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CeoDto [id=" + id + ", email=" + email + ", pw=" + pw + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + "]";
	}


}
