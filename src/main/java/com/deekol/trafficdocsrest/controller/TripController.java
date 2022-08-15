package com.deekol.trafficdocsrest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deekol.trafficdocsrest.domain.DocsEntity;
import com.deekol.trafficdocsrest.domain.TripEntity;
import com.deekol.trafficdocsrest.domain.enums.EQuantityUnit;
import com.deekol.trafficdocsrest.payload.request.TripRequest;
import com.deekol.trafficdocsrest.payload.response.MessageResponse;
import com.deekol.trafficdocsrest.payload.response.TripResponse;
import com.deekol.trafficdocsrest.repository.CounterpartyRepository;
import com.deekol.trafficdocsrest.repository.DocsRepository;
import com.deekol.trafficdocsrest.repository.TripRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/trip")
@AllArgsConstructor
@CrossOrigin
public class TripController {
	private final TripRepository tripRepository;
	private final CounterpartyRepository counterpartyRepository;
	private final DocsRepository docsRepository;
	
	@GetMapping
	public List<TripResponse> getAll() {
		List<TripEntity> tripEntityList = tripRepository.findAll();
		List<TripResponse> tripResponseList = new ArrayList<>();
		
		for(TripEntity tripEntity : tripEntityList) {
			Long docsIdEntity = null;
			
			if (tripEntity.getDocsEntity() != null) {
				docsIdEntity = tripEntity.getDocsEntity().getId();
			}
			
			TripResponse tripResponse = TripResponse.builder()
					.id(tripEntity.getId())
					.itinerary(tripEntity.getItinerary())
					.date(tripEntity.getDate())
					.quantity(tripEntity.getQuantity())
					.quantityUnit(tripEntity.getEQuantityUnit().toString())
					.price(tripEntity.getPrice())
					.consumer(tripEntity.getCounterpartyEntityConsumer().getName())
					.contractor(tripEntity.getCounterpartyEntityContractor().getName())
					.docsId(docsIdEntity)
					.build();
			
			tripResponseList.add(tripResponse);
		}
		
		return tripResponseList;
	}
	
	@GetMapping("{id}")
	public TripResponse getOne(@PathVariable("id") TripEntity tripEntity) {
		Long docsIdEntity = null;
		
		if (tripEntity.getDocsEntity() != null) {
			docsIdEntity = tripEntity.getDocsEntity().getId();
		}
		
		TripResponse tripResponse = TripResponse.builder()
				.id(tripEntity.getId())
				.itinerary(tripEntity.getItinerary())
				.date(tripEntity.getDate())
				.quantity(tripEntity.getQuantity())
				.quantityUnit(tripEntity.getEQuantityUnit().toString())
				.price(tripEntity.getPrice())
				.consumer(tripEntity.getCounterpartyEntityConsumer().getName())
				.contractor(tripEntity.getCounterpartyEntityContractor().getName())
				.docsId(docsIdEntity)
				.build();
		return tripResponse;
	}
	
	@PostMapping
	public /*ResponseEntity<?>*/ TripResponse create(@Valid @RequestBody TripRequest tripRequest) {
		DocsEntity docsEntity = null;
			
		if (tripRequest.getDocsId() != null) {
			docsEntity = docsRepository.getById(tripRequest.getDocsId());
		}
		
		TripEntity tripEntity = TripEntity.builder()
				.itinerary(tripRequest.getItinerary())
				.date(tripRequest.getDate())
				.quantity(tripRequest.getQuantity())
				.eQuantityUnit(EQuantityUnit.valueOf(tripRequest.getQuantityUnit()))
				.price(tripRequest.getPrice())
				.counterpartyEntityConsumer(counterpartyRepository.findByName(tripRequest.getConsumer()))
				.counterpartyEntityContractor(counterpartyRepository.findByName(tripRequest.getContractor()))
				.docsEntity(docsEntity)
				.build();
		
		TripEntity newTrip = tripRepository.save(tripEntity);
		
		TripResponse tripResponse = new TripResponse();
		tripResponse.setId(newTrip.getId());
		tripResponse.setItinerary(tripEntity.getItinerary());
		tripResponse.setDate(tripEntity.getDate());
		tripResponse.setQuantity(tripEntity.getQuantity());
		tripResponse.setQuantityUnit(tripEntity.getEQuantityUnit().toString());
		tripResponse.setPrice(tripEntity.getPrice());
		tripResponse.setConsumer(tripEntity.getCounterpartyEntityConsumer().getName());
		tripResponse.setContractor(tripEntity.getCounterpartyEntityContractor().getName());
		
		if (tripEntity.getDocsEntity() != null) {
			tripResponse.setDocsId(tripEntity.getDocsEntity().getId());
		}
		
		return tripResponse;
		
//		return ResponseEntity.ok(new MessageResponse("Trip added successfully!"));
	}
	
	@PutMapping("{id}")
	public /*ResponseEntity<?>*/ TripResponse update(@PathVariable("id") TripEntity tripFromDb, @Valid @RequestBody TripRequest tripRequest) {
		DocsEntity docsEntity = null;
		if (tripRequest.getDocsId() != null) {
			docsEntity = docsRepository.getById(tripRequest.getDocsId());
		}

		TripEntity tripEntity = TripEntity.builder()
				.itinerary(tripRequest.getItinerary())
				.date(tripRequest.getDate())
				.quantity(tripRequest.getQuantity())
				.eQuantityUnit(EQuantityUnit.valueOf(tripRequest.getQuantityUnit()))
				.price(tripRequest.getPrice())
				.counterpartyEntityConsumer(counterpartyRepository.findByName(tripRequest.getConsumer()))
				.counterpartyEntityContractor(counterpartyRepository.findByName(tripRequest.getContractor()))
				.docsEntity(docsEntity)
				.build();
		
		BeanUtils.copyProperties(tripEntity, tripFromDb, "id");
		tripRepository.save(tripFromDb);
		
		Long docsResponse = null;
		if (tripEntity.getDocsEntity() != null) {
			docsResponse = tripEntity.getDocsEntity().getId();
		}
		
		TripResponse tripResponse = TripResponse.builder()
				.id(tripFromDb.getId())
				.itinerary(tripEntity.getItinerary())
				.date(tripEntity.getDate())
				.quantity(tripEntity.getQuantity())
				.quantityUnit(tripEntity.getEQuantityUnit().toString())
				.price(tripEntity.getPrice())
				.consumer(tripEntity.getCounterpartyEntityConsumer().getName())
				.contractor(tripEntity.getCounterpartyEntityContractor().getName())
				.docsId(docsResponse)
				.build();
		
//		TripResponse tripResponse = new TripResponse();
//		tripResponse.setId(tripFromDb.getId());
//		tripResponse.setItinerary(tripEntity.getItinerary());
//		tripResponse.setDate(tripEntity.getDate());
//		tripResponse.setQuantity(tripEntity.getQuantity());
//		tripResponse.setQuantityUnit(tripEntity.getEQuantityUnit().toString());
//		tripResponse.setPrice(tripEntity.getPrice());
//		tripResponse.setConsumer(tripEntity.getCounterpartyEntityConsumer().getName());
//		tripResponse.setContractor(tripEntity.getCounterpartyEntityContractor().getName());
//		
//		if (tripEntity.getDocsEntity() != null) {
//			tripResponse.setDocsId(tripEntity.getDocsEntity().getId());
//		}
		
		return tripResponse;
		
//		return ResponseEntity.ok(new MessageResponse("Trip updated successfully!"));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") TripEntity tripEntity) {
		tripRepository.delete(tripEntity);
		
		return ResponseEntity.ok(new MessageResponse("Trip deleted successfully!"));
	}
}