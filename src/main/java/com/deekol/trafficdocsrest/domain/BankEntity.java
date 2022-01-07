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

import com.deekol.trafficdocsrest.domain.enums.EBusinessStructures;

import lombok.Data;

@Entity
@Table(name = "bank")
@Data
public class BankEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "business_structures_bank")
	@Enumerated(EnumType.STRING)
	private EBusinessStructures eBusinessStructuresBank;
	
	private String name;
	private String bik;
	
	@Column(name = "account_of_bank")
	private String accountOfBank;
	
	private String account;
	
	@OneToOne(mappedBy = "bankEntity")
	private ConsumerEntity consumerEntity;
	
	@OneToOne(mappedBy = "bankEntity")
	private ContractorEntity contractorEntity;
}
