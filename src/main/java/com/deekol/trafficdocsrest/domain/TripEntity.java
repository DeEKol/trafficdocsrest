package com.deekol.trafficdocsrest.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.deekol.trafficdocsrest.domain.enums.EQuantityUnit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trip")
@Data
@NoArgsConstructor
public class TripEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String itinerary;
	private LocalDate date;
	private Integer quantity;
	
	@Enumerated(EnumType.STRING)
	private EQuantityUnit eQuantityUnit;
	private BigDecimal price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="contractor_id", referencedColumnName = "id")
	private ContractorEntity contractorEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="consumer_id", referencedColumnName = "id")
	private ConsumerEntity consumerEntity;
	
	@ManyToOne
	@JoinColumn(name = "docs_id")
	private DocsEntity docsEntity;
}