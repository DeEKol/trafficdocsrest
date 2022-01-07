package com.deekol.trafficdocsrest.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
}
