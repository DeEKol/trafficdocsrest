package com.deekol.trafficdocsrest.domain.enums;

public enum ESubFederalUnit {
	ОБЛАСТЬ("обл"),
	РЕСПУБЛИКА("Республика"),
	КРАЙ("край"),
	АО("АО");
	
	String title;
	
	ESubFederalUnit(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
