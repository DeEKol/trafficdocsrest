package com.deekol.trafficdocsrest.payload.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.deekol.trafficdocsrest.domain.DocsEntity;
import com.deekol.trafficdocsrest.domain.TripEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TripResponse {
	@NotBlank
	private String id;
	
	@NotBlank
	private String itinerary;
	@NotBlank
	private LocalDate date;
	@NotBlank
	private Integer quantity;
	@NotBlank
	private String quantityUnit;
	@NotBlank
	private BigDecimal price;
	@NotBlank
	private String contractorEntity;
	@NotBlank
	private String consumerEntity;
	
	private DocsEntity docsEntity;
	
	public static TripResponse fromTripEntity(TripEntity tripEntity) {
		TripResponse tripResponse = new TripResponse();
		
		tripResponse.setId(tripEntity.getId().toString());
		tripResponse.setItinerary(tripEntity.getItinerary());
		tripResponse.setDate(tripEntity.getDate());
		tripResponse.setQuantity(tripEntity.getQuantity());
		tripResponse.setQuantityUnit(tripEntity.getEQuantityUnit().toString());
		tripResponse.setPrice(tripEntity.getPrice());
//		tripResponse.setContractorEntity(tripEntity.getContractorEntity().getName());
//		tripResponse.setConsumerEntity(tripEntity.getConsumerEntity().getName());
		
		if (tripEntity.getDocsEntity() != null) {
			tripResponse.setDocsEntity(tripEntity.getDocsEntity());
		}
		
		return tripResponse;
	}
}
