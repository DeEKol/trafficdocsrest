package com.deekol.trafficdocsrest.payload.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripResponse {
	private Long id;
	private String itinerary;
	private LocalDate date;
	private Integer quantity;
	private String quantityUnit;
	private BigDecimal price;
	private String consumer;
	private String contractor;
	private Long docsId;
}
