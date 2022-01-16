package com.deekol.trafficdocsrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deekol.trafficdocsrest.domain.TripEntity;
import com.deekol.trafficdocsrest.domain.enums.EQuantityUnit;
import com.deekol.trafficdocsrest.payload.request.TripRequest;
import com.deekol.trafficdocsrest.payload.response.MessageResponse;
import com.deekol.trafficdocsrest.repository.CounterpartyRepository;
import com.deekol.trafficdocsrest.repository.DocsRepository;
import com.deekol.trafficdocsrest.repository.TripRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/trip")
@AllArgsConstructor
public class TripController {
	private final TripRepository tripRepository;
	private final CounterpartyRepository counterpartyRepository;
	private final DocsRepository docsRepository;
	
	@GetMapping
	public List<TripEntity> getAll() {
		return tripRepository.findAll();
	}
	
	@GetMapping("{id}")
	public TripEntity getOne(@PathVariable("id") TripEntity tripEntity) {
		return tripEntity;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody TripRequest tripRequest) {
		TripEntity tripEntity = new TripEntity();
		
		tripEntity.setItinerary(tripRequest.getItinerary());
		tripEntity.setDate(tripRequest.getDate());
		tripEntity.setQuantity(tripRequest.getQuantity());
		tripEntity.setEQuantityUnit(EQuantityUnit.valueOf(tripRequest.getQuantityUnit()));
		tripEntity.setPrice(tripRequest.getPrice());
		
		tripEntity.setCounterpartyEntityConsumer(counterpartyRepository.findByName(tripRequest.getConsumer()));
		tripEntity.setCounterpartyEntityContractor(counterpartyRepository.findByName(tripRequest.getContractor()));
		
		tripEntity.setDocsEntity(docsRepository.getById(tripRequest.getDocsId()));
		
		tripRepository.save(tripEntity);
		
		return ResponseEntity.ok(new MessageResponse("Trip added successfully!"));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") TripEntity tripFromDb, @Valid @RequestBody TripRequest tripRequest) {
		TripEntity tripEntity = new TripEntity();
		
		tripEntity.setItinerary(tripRequest.getItinerary());
		tripEntity.setDate(tripRequest.getDate());
		tripEntity.setQuantity(tripRequest.getQuantity());
		tripEntity.setEQuantityUnit(EQuantityUnit.valueOf(tripRequest.getQuantityUnit()));
		tripEntity.setPrice(tripRequest.getPrice());
		
		tripEntity.setCounterpartyEntityConsumer(counterpartyRepository.findByName(tripRequest.getConsumer()));
		tripEntity.setCounterpartyEntityContractor(counterpartyRepository.findByName(tripRequest.getContractor()));
		
		tripEntity.setDocsEntity(docsRepository.getById(tripRequest.getDocsId()));
		
		BeanUtils.copyProperties(tripEntity, tripFromDb, "id");
		tripRepository.save(tripFromDb);
		
		return ResponseEntity.ok(new MessageResponse("Trip updated successfully!"));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") TripEntity tripEntity) {
		tripRepository.delete(tripEntity);
	}
}