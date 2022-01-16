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

import com.deekol.trafficdocsrest.domain.CounterpartyEntity;
import com.deekol.trafficdocsrest.domain.enums.EAppartmentUnit;
import com.deekol.trafficdocsrest.domain.enums.EBusinessStructure;
import com.deekol.trafficdocsrest.domain.enums.EHouseUnit;
import com.deekol.trafficdocsrest.domain.enums.EParticipant;
import com.deekol.trafficdocsrest.domain.enums.ESettlement;
import com.deekol.trafficdocsrest.domain.enums.EStreetUnit;
import com.deekol.trafficdocsrest.domain.enums.ESubFederalUnit;
import com.deekol.trafficdocsrest.payload.request.CounterpartyRequest;
import com.deekol.trafficdocsrest.payload.response.MessageResponse;
import com.deekol.trafficdocsrest.repository.CounterpartyRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/counterparty")
@AllArgsConstructor
public class CounterpartyController {
	private final CounterpartyRepository counterpartyRepository;
	
	@GetMapping
	public List<CounterpartyEntity> getAll() {
		return counterpartyRepository.findAll();
	}
	
	@GetMapping("{id}")
	public CounterpartyEntity getOne(@PathVariable("id") CounterpartyEntity counterpartyEntity) {
		return counterpartyEntity;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody CounterpartyRequest counterpartyRequest) {
		CounterpartyEntity counterpartyEntity = new CounterpartyEntity();
		
		counterpartyEntity.setEBusinessStructure(EBusinessStructure.valueOf(counterpartyRequest.getBusinessStructure()));
		counterpartyEntity.setName(counterpartyRequest.getName());
		counterpartyEntity.setEmail(counterpartyRequest.getEmail());
		counterpartyEntity.setInn(counterpartyRequest.getInn());
		counterpartyEntity.setKpp(counterpartyRequest.getKpp());
		counterpartyEntity.setEParticipant(EParticipant.valueOf(counterpartyRequest.getParticipant()));
		counterpartyEntity.setEBusinessStructureBank(EBusinessStructure.valueOf(counterpartyRequest.getBusinessStructureBank()));
		counterpartyEntity.setBank(counterpartyRequest.getBank());
		counterpartyEntity.setBik(counterpartyRequest.getBik());
		counterpartyEntity.setAccountOfBank(counterpartyRequest.getAccountOfBank());
		counterpartyEntity.setAccount(counterpartyRequest.getAccount());
		counterpartyEntity.setLocationIndex(counterpartyRequest.getLocationIndex());
		counterpartyEntity.setESubFederalUnit(ESubFederalUnit.valueOf(counterpartyRequest.getSubFederalUnit()));
		counterpartyEntity.setRegion(counterpartyRequest.getRegion());
		counterpartyEntity.setESettlement(ESettlement.valueOf(counterpartyRequest.getSettlement()));
		counterpartyEntity.setCity(counterpartyRequest.getCity());
		counterpartyEntity.setEStreetUnit(EStreetUnit.valueOf(counterpartyRequest.getStreetUnit()));
		counterpartyEntity.setStreet(counterpartyRequest.getStreet());
		counterpartyEntity.setEHouseUnit(EHouseUnit.valueOf(counterpartyRequest.getHouseUnit()));
		counterpartyEntity.setHouse(counterpartyRequest.getHouse());
		counterpartyEntity.setEAppartmentUnit(EAppartmentUnit.valueOf(counterpartyRequest.getAppartmentUnit()));
		counterpartyEntity.setAppartment(counterpartyRequest.getAppartment());
		
		counterpartyRepository.save(counterpartyEntity);
		
		return ResponseEntity.ok(new MessageResponse("Counterparty added successfully!"));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") CounterpartyEntity counterpartyFromDb, @Valid @RequestBody CounterpartyRequest counterpartyRequest) {
		CounterpartyEntity counterpartyEntity = new CounterpartyEntity();
		
		counterpartyEntity.setEBusinessStructure(EBusinessStructure.valueOf(counterpartyRequest.getBusinessStructure()));
		counterpartyEntity.setName(counterpartyRequest.getName());
		counterpartyEntity.setEmail(counterpartyRequest.getEmail());
		counterpartyEntity.setInn(counterpartyRequest.getInn());
		counterpartyEntity.setKpp(counterpartyRequest.getKpp());
		counterpartyEntity.setEParticipant(EParticipant.valueOf(counterpartyRequest.getParticipant()));
		counterpartyEntity.setEBusinessStructureBank(EBusinessStructure.valueOf(counterpartyRequest.getBusinessStructureBank()));
		counterpartyEntity.setBank(counterpartyRequest.getBank());
		counterpartyEntity.setBik(counterpartyRequest.getBik());
		counterpartyEntity.setAccountOfBank(counterpartyRequest.getAccountOfBank());
		counterpartyEntity.setAccount(counterpartyRequest.getAccount());
		counterpartyEntity.setLocationIndex(counterpartyRequest.getLocationIndex());
		counterpartyEntity.setESubFederalUnit(ESubFederalUnit.valueOf(counterpartyRequest.getSubFederalUnit()));
		counterpartyEntity.setRegion(counterpartyRequest.getRegion());
		counterpartyEntity.setESettlement(ESettlement.valueOf(counterpartyRequest.getSettlement()));
		counterpartyEntity.setCity(counterpartyRequest.getCity());
		counterpartyEntity.setEStreetUnit(EStreetUnit.valueOf(counterpartyRequest.getStreetUnit()));
		counterpartyEntity.setStreet(counterpartyRequest.getStreet());
		counterpartyEntity.setEHouseUnit(EHouseUnit.valueOf(counterpartyRequest.getHouseUnit()));
		counterpartyEntity.setHouse(counterpartyRequest.getHouse());
		counterpartyEntity.setEAppartmentUnit(EAppartmentUnit.valueOf(counterpartyRequest.getAppartmentUnit()));
		counterpartyEntity.setAppartment(counterpartyRequest.getAppartment());
		
		BeanUtils.copyProperties(counterpartyEntity, counterpartyFromDb, "id");
		counterpartyRepository.save(counterpartyFromDb);
		
		return ResponseEntity.ok(new MessageResponse("Counterparty updated successfully!"));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable("id") CounterpartyEntity counterpartyEntity) {
		counterpartyRepository.delete(counterpartyEntity);
		
		return ResponseEntity.ok(new MessageResponse("Counterparty deleted successfully!"));
	}
}
