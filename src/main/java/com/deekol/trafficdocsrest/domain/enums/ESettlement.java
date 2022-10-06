package com.deekol.trafficdocsrest.domain.enums;

public enum ESettlement {
	ГОРОД("г"),
	ДЕРЕВНЯ("д"),
	СЕЛО("с"),
	ПОСЁЛОК("п"),
	СТАНЦИЯ("ст");
	
	String title;
	
	ESettlement(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
