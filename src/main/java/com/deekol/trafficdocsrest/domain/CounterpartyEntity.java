package com.deekol.trafficdocsrest.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.deekol.trafficdocsrest.domain.enums.EAppartmentUnit;
import com.deekol.trafficdocsrest.domain.enums.EBusinessStructure;
import com.deekol.trafficdocsrest.domain.enums.EHouseUnit;
import com.deekol.trafficdocsrest.domain.enums.EParticipant;
import com.deekol.trafficdocsrest.domain.enums.ESettlement;
import com.deekol.trafficdocsrest.domain.enums.EStreetUnit;
import com.deekol.trafficdocsrest.domain.enums.ESubFederalUnit;

import lombok.Data;

@Entity
@Data
@Table(name = "counterparty")
public class CounterpartyEntity {
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
	
	@Column(name = "participant")
	@Enumerated(EnumType.STRING)
	private EParticipant eParticipant;
	
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
	
	@OneToMany(mappedBy = "counterpartyEntityConsumer", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	private Set<TripEntity> tripsConsumer;
	
	@OneToMany(mappedBy = "counterpartyEntityContractor", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	private Set<TripEntity> tripsContractor;
	
	@OneToMany(mappedBy = "counterpartyEntityConsumer", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	private Set<DocsEntity> docsConsumer;
	
	@OneToMany(mappedBy = "counterpartyEntityContractor", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
	private Set<DocsEntity> docsContractor;
}
