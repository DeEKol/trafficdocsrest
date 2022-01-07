package com.deekol.trafficdocsrest.domain;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="bank_id", referencedColumnName = "id")
	private BankEntity bankEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="address_id", referencedColumnName = "id")
	private AddressEntity addressEntity;
}
