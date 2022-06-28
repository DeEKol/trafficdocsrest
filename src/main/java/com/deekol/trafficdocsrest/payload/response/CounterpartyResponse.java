package com.deekol.trafficdocsrest.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CounterpartyResponse {
	private Long id;
	private String businessStructure;
	private String name;
	private String email;
	private String inn;
	private String kpp;
	private String participant;
	private String businessStructureBank;
	private String bank;
	private String bik;
	private String accountOfBank;
	private String account;
	private String locationIndex;
	private String subFederalUnit;
	private String region;
	private String settlement;
	private String city;
	private String streetUnit;
	private String street;
	private String houseUnit;
	private String house;
	private String appartmentUnit;
	private String appartment;
}
