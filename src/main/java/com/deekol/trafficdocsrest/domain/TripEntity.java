package com.deekol.trafficdocsrest.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deekol.trafficdocsrest.domain.enums.QuantityUnit;

import lombok.Data;

@Entity
@Table(name = "trip")
@Data
public class TripEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String itinerary;
	private LocalDate date;
	private Integer quantity;
	
	@Enumerated(EnumType.STRING)
	private QuantityUnit quantityUnit;
	private BigDecimal price;
}
