package com.pickme.beeze.store.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapPointParams {
	private Map<String, Double> nw;
	private Map<String, Double> ne;
	private Map<String, Double> sw;
}
