package com.deekol.trafficdocsrest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class DocsXlsDto {
	long docsId;
	
	LocalDate docsDate;
	
	//Описание контрагента
	String contractorDescription;
	String consumerDescription;
	
	LocalDate tripDate;
	
	//Описание услуги
	private String tripDescription;

	private Integer quantity;
	private String quantityUnit;
	
	private BigDecimal price;
}
