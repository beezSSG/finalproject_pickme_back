package com.pickme.beeze.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MypageSaveDto {
	@NonNull private int productId;
	@NonNull private int customerId;
}
