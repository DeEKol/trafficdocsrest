package com.deekol.trafficdocsrest.domain.enums;

public enum EStreetUnit {
	УЛИЦА("ул"),
	ШОССЕ("ш"),
	ПРОСПЕКТ("пр");
	
	String title;
	
	EStreetUnit(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
