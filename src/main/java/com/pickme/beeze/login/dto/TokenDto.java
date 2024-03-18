package com.pickme.beeze.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {	// 토큰용 dto

    private String jwtauthtoken;
	private int id;
	private String email;
	private String name;

}
