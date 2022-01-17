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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.deekol.trafficdocsrest.domain.enums.EQuantityUnit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trip")
@Data
@NoArgsConstructor
public class TripEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String itinerary;
	@NotBlank
	private LocalDate date;
	@NotBlank
	private Integer quantity;
	
	@NotBlank
	@Size(max = 10)
	@Column(name = "quantity_unit")
	@Enumerated(EnumType.STRING)
	private EQuantityUnit eQuantityUnit;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "docs_id")
	private DocsEntity docsEntity;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumer_id")
	private CounterpartyEntity counterpartyEntityConsumer;
	
	@NotBlank
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractor_id")
	private CounterpartyEntity counterpartyEntityContractor;
}
