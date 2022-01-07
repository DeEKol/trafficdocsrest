package com.deekol.trafficdocsrest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.deekol.trafficdocsrest.domain.enums.EAppartmentUnit;
import com.deekol.trafficdocsrest.domain.enums.EHouseUnit;
import com.deekol.trafficdocsrest.domain.enums.ESettlement;
import com.deekol.trafficdocsrest.domain.enums.EStreetUnit;
import com.deekol.trafficdocsrest.domain.enums.ESubFederalUnit;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
	
	@OneToOne(mappedBy = "addressEntity")
	private ContractorEntity contractorEntity;
	
	@OneToOne(mappedBy = "addressEntity")
	private ConsumerEntity consumerEntity;
}
