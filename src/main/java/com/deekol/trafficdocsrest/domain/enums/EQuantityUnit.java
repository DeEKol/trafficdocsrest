package com.deekol.trafficdocsrest.domain.enums;

public enum EQuantityUnit {
	ШТУК ("шт"),
	ЧАСОВ ("ч");

	String title;
	
	EQuantityUnit(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
