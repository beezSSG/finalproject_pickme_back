package com.pickme.beeze.ceo.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("SalesChartDto")
public class SalesChartDto {
	
		private String orderYear;
		private String orderMonth;
		private int totalMonthlySales;
		
}
