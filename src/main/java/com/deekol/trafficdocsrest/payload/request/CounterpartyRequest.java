package com.deekol.trafficdocsrest.payload.request;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CounterpartyRequest {
	@NotBlank
	@Size(max = 3)
	@Column(name = "business_structure")
	private String businessStructure;
	
	@NotBlank
	@Size(max = 120)
	private String name;
	
	@NotBlank
	@Email
	@Size(max = 50)
	private String email;
	
	@NotBlank
	@Size(max = 15)
	private String inn;
	
	@NotBlank
	@Size(max = 15)
	private String kpp;
	
	@NotBlank
	private String participant;
	
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
	
//	@NotBlank
	private String appartmentUnit;
	
//	@NotBlank
	private String appartment;
}
