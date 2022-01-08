package com.deekol.trafficdocsrest.domain;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.deekol.trafficdocsrest.domain.enums.EAppartmentUnit;
import com.deekol.trafficdocsrest.domain.enums.EBusinessStructures;
import com.deekol.trafficdocsrest.domain.enums.EHouseUnit;
import com.deekol.trafficdocsrest.domain.enums.ESettlement;
import com.deekol.trafficdocsrest.domain.enums.EStreetUnit;
import com.deekol.trafficdocsrest.domain.enums.ESubFederalUnit;

import lombok.Data;

@MappedSuperclass
@Data
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String type;
	private String name;
	private String email;
	private String inn;
	private String kpp;
	
	
	@Column(name = "business_structures_bank")
	@Enumerated(EnumType.STRING)
	private EBusinessStructures eBusinessStructuresBank;
	
	private String bank;
	private String bik;
	
	@Column(name = "account_of_bank")
	private String accountOfBank;
	
	private String account;
	
	
	@Column(name = "location_index")
	private String locationIndex;
	
	@Column(name = "sub_federal_unit")
	@Enumerated(EnumType.STRING)
	private ESubFederalUnit eSubFederalUnit;
	
	private String region;
	
	@Column(name = "settlement")
	@Enumerated(EnumType.STRING)
	private ESettlement eSettlement;
	
	private String city;
	
	@Column(name = "street_unit")
	@Enumerated(EnumType.STRING)
	private EStreetUnit eStreetUnit = EStreetUnit.УЛИЦА;
	
	private String street;
	
	@Column(name = "house_unit")
	@Enumerated(EnumType.STRING)
	private EHouseUnit eHouseUnit = EHouseUnit.ДОМ;
	
	private String house;
	
	@Column(name = "appartment_unit")
	@Enumerated(EnumType.STRING)
	private EAppartmentUnit eAppartmentUnit;
	
	private String appartment;
}
