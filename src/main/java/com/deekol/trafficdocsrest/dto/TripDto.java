package com.deekol.trafficdocsrest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TripDto {
	
//	@NotBlank
//	private String itinerary;
//	@NotNull
//	private LocalDate date;
	
	private String description;

//	@Min(1)
	private Integer quantity;
//	@NotBlank
	private String quantityUnit;
	
//	@Min(1)
	private BigDecimal price;
//	@NotBlank
//	private String consumer;
//	@NotBlank
//	private String contractor;
	
//	private Long docsId;
}
