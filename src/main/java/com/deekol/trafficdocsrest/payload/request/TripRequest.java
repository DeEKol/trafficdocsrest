package com.deekol.trafficdocsrest.payload.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TripRequest {
	@NotBlank
	private String itinerary;
	@NotNull
	private LocalDate date;

	@Min(1)
	private Integer quantity;
	@NotBlank
	private String quantityUnit;
	
	@Min(1)
	private BigDecimal price;
	@NotBlank
	private String consumer;
	@NotBlank
	private String contractor;
	
	private Long docsId;
}
