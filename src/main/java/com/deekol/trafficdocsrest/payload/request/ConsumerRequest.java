package com.deekol.trafficdocsrest.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConsumerRequest {
	
	@NotBlank
	private String businessStructure;
	
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String inn;
	@NotBlank
	private String kpp;
	
	@NotBlank
	private String businessStructureBank;
	
	@NotBlank
	private String bank;
	@NotBlank
	private String bik;
	@NotBlank
	private String accountOfBank;
	@NotBlank
	private String account;
	@NotBlank
	private String locationIndex;
	@NotBlank
	
	@NotBlank
	private String subFederalUnit;
	
	@NotBlank
	private String region;
	
	@NotBlank
	private String settlement;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String streetUnit;
	
	@NotBlank
	private String street;
	
	@NotBlank
	private String houseUnit;
	
	@NotBlank
	private String house;
	
	@NotBlank
	private String appartmentUnit;
	
	@NotBlank
	private String appartment;
}
