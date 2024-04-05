package com.pickme.beeze.product.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("ProductGiftParam")
public class ProductGiftParam {

		private int id;
		private String email;
		private String name;
		
}
