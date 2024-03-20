package com.pickme.beeze.login.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CustomerDto {
	
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String picture;
	
	@Builder
	public CustomerDto(Long id, String username, String password, String email, String picture) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.picture = picture;
	}
	
	public CustomerDto update(String username, String picture) {
		this.username = username;
		this.picture = picture;
		return this;
	}
}
