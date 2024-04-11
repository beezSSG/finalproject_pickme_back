package com.pickme.beeze.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
	
	private int id;
	private int ceoId;
	private String brFilename;
	private String name;
	private double lon;
	private double lat;
	private String tel;
	private int openEnded;
	private int unmanned;
	private int delivery;
	private int atm;
	private int sellWine;
	private int sellCoffee;
	private int smoothieking;
	private int appleAcc;
	private int toto;
	private String address;
	
	
}
