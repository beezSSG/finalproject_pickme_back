package com.pickme.beeze.store.dto;


public class StoreDto {
	
	private int id;
	private int ceo_id;
	private String br_filename;
	private String name;
	private double lon;
	private double lat;
	private String tel;
	private int open_ended;
	private int unmanned;
	private int delivery;
	private int atm;
	private int sell_wine;
	private int sell_coffee;
	private int smoothieking;
	private int apple_acc;
	private int toto;
	private String address;
	
	
	public StoreDto() {		
	}


	public StoreDto(int id, int ceo_id, String br_filename, String name, double lon, double lat, String tel,
			int open_ended, int unmanned, int delivery, int atm, int sell_wine, int sell_coffee, int smoothieking,
			int apple_acc, int toto, String address) {
		super();
		this.id = id;
		this.ceo_id = ceo_id;
		this.br_filename = br_filename;
		this.name = name;
		this.lon = lon;
		this.lat = lat;
		this.tel = tel;
		this.open_ended = open_ended;
		this.unmanned = unmanned;
		this.delivery = delivery;
		this.atm = atm;
		this.sell_wine = sell_wine;
		this.sell_coffee = sell_coffee;
		this.smoothieking = smoothieking;
		this.apple_acc = apple_acc;
		this.toto = toto;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCeo_id() {
		return ceo_id;
	}


	public void setCeo_id(int ceo_id) {
		this.ceo_id = ceo_id;
	}


	public String getBr_filename() {
		return br_filename;
	}


	public void setBr_filename(String br_filename) {
		this.br_filename = br_filename;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getLon() {
		return lon;
	}


	public void setLon(double lon) {
		this.lon = lon;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public int getOpen_ended() {
		return open_ended;
	}


	public void setOpen_ended(int open_ended) {
		this.open_ended = open_ended;
	}


	public int getUnmanned() {
		return unmanned;
	}


	public void setUnmanned(int unmanned) {
		this.unmanned = unmanned;
	}


	public int getDelivery() {
		return delivery;
	}


	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}


	public int getAtm() {
		return atm;
	}


	public void setAtm(int atm) {
		this.atm = atm;
	}


	public int getSell_wine() {
		return sell_wine;
	}


	public void setSell_wine(int sell_wine) {
		this.sell_wine = sell_wine;
	}


	public int getSell_coffee() {
		return sell_coffee;
	}


	public void setSell_coffee(int sell_coffee) {
		this.sell_coffee = sell_coffee;
	}


	public int getSmoothieking() {
		return smoothieking;
	}


	public void setSmoothieking(int smoothieking) {
		this.smoothieking = smoothieking;
	}


	public int getApple_acc() {
		return apple_acc;
	}


	public void setApple_acc(int apple_acc) {
		this.apple_acc = apple_acc;
	}


	public int getToto() {
		return toto;
	}


	public void setToto(int toto) {
		this.toto = toto;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "StoreDto [id=" + id + ", ceo_id=" + ceo_id + ", br_filename=" + br_filename + ", name=" + name
				+ ", lon=" + lon + ", lat=" + lat + ", tel=" + tel + ", open_ended=" + open_ended + ", unmanned="
				+ unmanned + ", delivery=" + delivery + ", atm=" + atm + ", sell_wine=" + sell_wine + ", sell_coffee="
				+ sell_coffee + ", smoothieking=" + smoothieking + ", apple_acc=" + apple_acc + ", toto=" + toto
				+ ", address=" + address + "]";
	}
	
	
	
	
}
