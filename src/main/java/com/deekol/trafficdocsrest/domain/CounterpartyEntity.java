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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Table(	name = "counterparty",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "name"),
				@UniqueConstraint(columnNames = "email"),
				@UniqueConstraint(columnNames = "inn"),
				@UniqueConstraint(columnNames = "account")
		})
public class CounterpartyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 3)
	@Column(name = "business_structure")
	@Enumerated(EnumType.STRING)
	private EBusinessStructure eBusinessStructure;
	
	@NotBlank
	@Size(max = 120)
	private String name;
	@Size(max = 50)
	@NotBlank
	private String email;
	@Size(max = 15)
	@NotBlank
	private String inn;
	@Size(max = 15)
	@NotBlank
	private String kpp;
	
	@NotBlank
	@Column(name = "participant")
	@Enumerated(EnumType.STRING)
	private EParticipant eParticipant;
	
	@NotBlank
	@Column(name = "business_structure_bank")
	@Enumerated(EnumType.STRING)
	private EBusinessStructure eBusinessStructureBank;
	
	@NotBlank
	private String bank;
	@NotBlank
	private String bik;
	
	@NotBlank
	@Column(name = "account_of_bank")
	private String accountOfBank;
	
	@NotBlank
	private String account;
	
	@NotBlank
	@Column(name = "location_index")
	private String locationIndex;
	
	@NotBlank
	@Column(name = "sub_federal_unit")
	@Enumerated(EnumType.STRING)
	private ESubFederalUnit eSubFederalUnit;
	
	@NotBlank
	private String region;
	
	@NotBlank
	@Column(name = "settlement")
	@Enumerated(EnumType.STRING)
	private ESettlement eSettlement;
	
	@NotBlank
	private String city;
	
	@NotBlank
	@Column(name = "street_unit")
	@Enumerated(EnumType.STRING)
	private EStreetUnit eStreetUnit = EStreetUnit.УЛИЦА;
	
	@NotBlank
	private String street;
	
	@NotBlank
	@Column(name = "house_unit")
	@Enumerated(EnumType.STRING)
	private EHouseUnit eHouseUnit = EHouseUnit.ДОМ;
	
	@NotBlank
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
