package com.deekol.trafficdocsrest.domain.enums;

public enum EHouseUnit {
	ДОМ("д"),
	ПОМЕЩЕНИЕ("пом");
	
	String title;
	
	EHouseUnit(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
