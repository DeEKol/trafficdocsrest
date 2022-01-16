package com.deekol.trafficdocsrest.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "quantity_unit")
	@Enumerated(EnumType.STRING)
	private EQuantityUnit eQuantityUnit;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "docs_id")
	private DocsEntity docsEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumer_id")
	private CounterpartyEntity counterpartyEntityConsumer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractor_id")
	private CounterpartyEntity counterpartyEntityContractor;
}
