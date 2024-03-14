package com.pickme.beeze.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MypageCartDto {
	private int customerId;
	private int sProductId;
}
