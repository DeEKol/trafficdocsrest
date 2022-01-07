package com.deekol.trafficdocsrest.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "docs")
@Data
public class DocsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate date;
	private Boolean post;
	private Boolean pay;
	
	@OneToMany(mappedBy = "docsEntity")
	private Set<TripEntity> tripEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="contractor_id", referencedColumnName = "id")
	private ContractorEntity contractorEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="consumer_id", referencedColumnName = "id")
	private ConsumerEntity consumerEntity;
}
