package com.pickme.beeze.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {
	private String email; 	// id
	private String pw; 		// pw
	
	public UserLoginDto() {
	}

	public UserLoginDto(String email, String pw) {
		this.email = email;
		this.pw = pw;
	}
	
	public UserLoginDto(UserDto userDto) {
		this.email = userDto.getEmail();
		this.pw = userDto.getPw();
	}
	
}
