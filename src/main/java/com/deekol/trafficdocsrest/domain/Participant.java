package com.deekol.trafficdocsrest.domain;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.deekol.trafficdocsrest.domain.enums.EAppartmentUnit;
import com.deekol.trafficdocsrest.domain.enums.EBusinessStructure;
import com.deekol.trafficdocsrest.domain.enums.EHouseUnit;
import com.deekol.trafficdocsrest.domain.enums.ESettlement;
import com.deekol.trafficdocsrest.domain.enums.EStreetUnit;
import com.deekol.trafficdocsrest.domain.enums.ESubFederalUnit;

import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "business_structure")
	@Enumerated(EnumType.STRING)
	private EBusinessStructure eBusinessStructure;
	
	private String name;
	private String email;
	private String inn;
	private String kpp;
	
	
	@Column(name = "business_structure_bank")
	@Enumerated(EnumType.STRING)
	private EBusinessStructure eBusinessStructureBank;
	
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

	public Participant(EBusinessStructure eBusinessStructure, String name, String email, String inn, String kpp,
			EBusinessStructure eBusinessStructureBank, String bank, String bik, String accountOfBank, String account,
			String locationIndex, ESubFederalUnit eSubFederalUnit, String region, ESettlement eSettlement, String city,
			EStreetUnit eStreetUnit, String street, EHouseUnit eHouseUnit, String house,
			EAppartmentUnit eAppartmentUnit, String appartment) {
		this.eBusinessStructure = eBusinessStructure;
		this.name = name;
		this.email = email;
		this.inn = inn;
		this.kpp = kpp;
		this.eBusinessStructureBank = eBusinessStructureBank;
		this.bank = bank;
		this.bik = bik;
		this.accountOfBank = accountOfBank;
		this.account = account;
		this.locationIndex = locationIndex;
		this.eSubFederalUnit = eSubFederalUnit;
		this.region = region;
		this.eSettlement = eSettlement;
		this.city = city;
		this.eStreetUnit = eStreetUnit;
		this.street = street;
		this.eHouseUnit = eHouseUnit;
		this.house = house;
		this.eAppartmentUnit = eAppartmentUnit;
		this.appartment = appartment;
	}

	public Participant(Long id, EBusinessStructure eBusinessStructure, String name, String email, String inn,
			String kpp, EBusinessStructure eBusinessStructureBank, String bank, String bik, String accountOfBank,
			String account, String locationIndex, ESubFederalUnit eSubFederalUnit, String region,
			ESettlement eSettlement, String city, EStreetUnit eStreetUnit, String street, EHouseUnit eHouseUnit,
			String house, EAppartmentUnit eAppartmentUnit, String appartment) {
		super();
		this.id = id;
		this.eBusinessStructure = eBusinessStructure;
		this.name = name;
		this.email = email;
		this.inn = inn;
		this.kpp = kpp;
		this.eBusinessStructureBank = eBusinessStructureBank;
		this.bank = bank;
		this.bik = bik;
		this.accountOfBank = accountOfBank;
		this.account = account;
		this.locationIndex = locationIndex;
		this.eSubFederalUnit = eSubFederalUnit;
		this.region = region;
		this.eSettlement = eSettlement;
		this.city = city;
		this.eStreetUnit = eStreetUnit;
		this.street = street;
		this.eHouseUnit = eHouseUnit;
		this.house = house;
		this.eAppartmentUnit = eAppartmentUnit;
		this.appartment = appartment;
	}

}
