package com.deekol.trafficdocsrest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.deekol.trafficdocsrest.domain.CounterpartyEntity;
import com.deekol.trafficdocsrest.domain.DocsEntity;
import com.deekol.trafficdocsrest.domain.TripEntity;
import com.deekol.trafficdocsrest.domain.enums.EQuantityUnit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class TripDto {
	
	private Long id;
	private String itinerary;
	private LocalDate date;
	private Integer quantity;
	
	private EQuantityUnit eQuantityUnit;
	private BigDecimal price;
	
	private DocsEntity docsEntity;
	
	private CounterpartyEntity counterpartyEntityConsumer;
	
	private CounterpartyEntity counterpartyEntityContractor;
}
