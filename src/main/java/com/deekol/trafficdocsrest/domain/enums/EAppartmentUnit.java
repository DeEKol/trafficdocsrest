package com.deekol.trafficdocsrest.domain.enums;

public enum EAppartmentUnit {
	КВАРТИРА("кв"),
	ОФИС("оф");
	
	String title;
	
	EAppartmentUnit(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
