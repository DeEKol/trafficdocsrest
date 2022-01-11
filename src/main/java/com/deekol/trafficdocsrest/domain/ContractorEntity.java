package com.deekol.trafficdocsrest.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.deekol.trafficdocsrest.domain.enums.EAppartmentUnit;
import com.deekol.trafficdocsrest.domain.enums.EBusinessStructure;
import com.deekol.trafficdocsrest.domain.enums.EHouseUnit;
import com.deekol.trafficdocsrest.domain.enums.ESettlement;
import com.deekol.trafficdocsrest.domain.enums.EStreetUnit;
import com.deekol.trafficdocsrest.domain.enums.ESubFederalUnit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cotractor")
@Data
@EqualsAndHashCode(callSuper = true)
public class ContractorEntity extends Participant {
	@OneToOne(mappedBy = "contractorEntity")
	private TripEntity tripEntity;
	
	@OneToOne(mappedBy = "contractorEntity")
	private DocsEntity docsEntity;

	public ContractorEntity(EBusinessStructure eBusinessStructure, String name, String email, String inn, String kpp,
			EBusinessStructure eBusinessStructureBank, String bank, String bik, String accountOfBank, String account,
			String locationIndex, ESubFederalUnit eSubFederalUnit, String region, ESettlement eSettlement, String city,
			EStreetUnit eStreetUnit, String street, EHouseUnit eHouseUnit, String house,
			EAppartmentUnit eAppartmentUnit, String appartment) {
		super(eBusinessStructure, name, email, inn, kpp, eBusinessStructureBank, bank, bik, accountOfBank, account,
				locationIndex, eSubFederalUnit, region, eSettlement, city, eStreetUnit, street, eHouseUnit, house,
				eAppartmentUnit, appartment);
		// TODO Auto-generated constructor stub
	}
	
	
}
