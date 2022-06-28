package com.deekol.trafficdocsrest.controller;

import java.util.ArrayList;
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
import com.deekol.trafficdocsrest.payload.response.CounterpartyResponse;
import com.deekol.trafficdocsrest.payload.response.MessageResponse;
import com.deekol.trafficdocsrest.repository.CounterpartyRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/counterparty")
@AllArgsConstructor
public class CounterpartyController {
	private final CounterpartyRepository counterpartyRepository;
	
	@GetMapping
	public List<CounterpartyResponse> getAll() {
		List<CounterpartyEntity> counterpartyEntityList = counterpartyRepository.findAll();
		List<CounterpartyResponse> counterpartyResponseList = new ArrayList<>();
		
		for(CounterpartyEntity counterpartyEntity : counterpartyEntityList) {			
			CounterpartyResponse counterpartyResponse = CounterpartyResponse.builder()
					.id(counterpartyEntity.getId())
					.businessStructure(counterpartyEntity.getEBusinessStructure().toString())
					.name(counterpartyEntity.getName())
					.email(counterpartyEntity.getEmail())
					.inn(counterpartyEntity.getInn())
					.kpp(counterpartyEntity.getKpp())
					.participant(counterpartyEntity.getEParticipant().toString())
					.businessStructureBank(counterpartyEntity.getEBusinessStructureBank().toString())
					.bank(counterpartyEntity.getBank())
					.bik(counterpartyEntity.getBik())
					.accountOfBank(counterpartyEntity.getAccountOfBank())
					.account(counterpartyEntity.getAccount())
					.locationIndex(counterpartyEntity.getLocationIndex())
					.subFederalUnit(counterpartyEntity.getESubFederalUnit().toString())
					.region(counterpartyEntity.getRegion())
					.settlement(counterpartyEntity.getESettlement().toString())
					.city(counterpartyEntity.getCity())
					.streetUnit(counterpartyEntity.getEStreetUnit().toString())
					.street(counterpartyEntity.getStreet())
					.houseUnit(counterpartyEntity.getEHouseUnit().toString())
					.house(counterpartyEntity.getHouse())
					.appartmentUnit(counterpartyEntity.getEAppartmentUnit().toString())
					.appartment(counterpartyEntity.getAppartment())
					.build();
			
			counterpartyResponseList.add(counterpartyResponse);
		}
		
		return counterpartyResponseList;
	}
	
	@GetMapping("{id}")
	public CounterpartyResponse getOne(@PathVariable("id") CounterpartyEntity counterpartyEntity) {		
		CounterpartyResponse counterpartyResponse = CounterpartyResponse.builder()
				.id(counterpartyEntity.getId())
				.businessStructure(counterpartyEntity.getEBusinessStructure().toString())
				.name(counterpartyEntity.getName())
				.email(counterpartyEntity.getEmail())
				.inn(counterpartyEntity.getInn())
				.kpp(counterpartyEntity.getKpp())
				.participant(counterpartyEntity.getEParticipant().toString())
				.businessStructureBank(counterpartyEntity.getEBusinessStructureBank().toString())
				.bank(counterpartyEntity.getBank())
				.bik(counterpartyEntity.getBik())
				.accountOfBank(counterpartyEntity.getAccountOfBank())
				.account(counterpartyEntity.getAccount())
				.locationIndex(counterpartyEntity.getLocationIndex())
				.subFederalUnit(counterpartyEntity.getESubFederalUnit().toString())
				.region(counterpartyEntity.getRegion())
				.settlement(counterpartyEntity.getESettlement().toString())
				.city(counterpartyEntity.getCity())
				.streetUnit(counterpartyEntity.getEStreetUnit().toString())
				.street(counterpartyEntity.getStreet())
				.houseUnit(counterpartyEntity.getEHouseUnit().toString())
				.house(counterpartyEntity.getHouse())
				.appartmentUnit(counterpartyEntity.getEAppartmentUnit().toString())
				.appartment(counterpartyEntity.getAppartment())
				.build();
		
		return counterpartyResponse;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody CounterpartyRequest counterpartyRequest) {
//		CounterpartyEntity counterpartyEntity = new CounterpartyEntity();
//		
//		counterpartyEntity.setEBusinessStructure(EBusinessStructure.valueOf(counterpartyRequest.getBusinessStructure()));
//		counterpartyEntity.setName(counterpartyRequest.getName());
//		counterpartyEntity.setEmail(counterpartyRequest.getEmail());
//		counterpartyEntity.setInn(counterpartyRequest.getInn());
//		counterpartyEntity.setKpp(counterpartyRequest.getKpp());
//		counterpartyEntity.setEParticipant(EParticipant.valueOf(counterpartyRequest.getParticipant()));
//		counterpartyEntity.setEBusinessStructureBank(EBusinessStructure.valueOf(counterpartyRequest.getBusinessStructureBank()));
//		counterpartyEntity.setBank(counterpartyRequest.getBank());
//		counterpartyEntity.setBik(counterpartyRequest.getBik());
//		counterpartyEntity.setAccountOfBank(counterpartyRequest.getAccountOfBank());
//		counterpartyEntity.setAccount(counterpartyRequest.getAccount());
//		counterpartyEntity.setLocationIndex(counterpartyRequest.getLocationIndex());
//		counterpartyEntity.setESubFederalUnit(ESubFederalUnit.valueOf(counterpartyRequest.getSubFederalUnit()));
//		counterpartyEntity.setRegion(counterpartyRequest.getRegion());
//		counterpartyEntity.setESettlement(ESettlement.valueOf(counterpartyRequest.getSettlement()));
//		counterpartyEntity.setCity(counterpartyRequest.getCity());
//		counterpartyEntity.setEStreetUnit(EStreetUnit.valueOf(counterpartyRequest.getStreetUnit()));
//		counterpartyEntity.setStreet(counterpartyRequest.getStreet());
//		counterpartyEntity.setEHouseUnit(EHouseUnit.valueOf(counterpartyRequest.getHouseUnit()));
//		counterpartyEntity.setHouse(counterpartyRequest.getHouse());
//		counterpartyEntity.setEAppartmentUnit(EAppartmentUnit.valueOf(counterpartyRequest.getAppartmentUnit()));
//		counterpartyEntity.setAppartment(counterpartyRequest.getAppartment());
		
		CounterpartyEntity counterpartyEntity = CounterpartyEntity.builder()
				.eBusinessStructure(EBusinessStructure.valueOf(counterpartyRequest.getBusinessStructure()))
				.name(counterpartyRequest.getName())
				.email(counterpartyRequest.getEmail())
				.inn(counterpartyRequest.getInn())
				.kpp(counterpartyRequest.getKpp())
				.eParticipant(EParticipant.valueOf(counterpartyRequest.getParticipant()))
				.eBusinessStructureBank(EBusinessStructure.valueOf(counterpartyRequest.getBusinessStructureBank()))
				.bank(counterpartyRequest.getBank())
				.bik(counterpartyRequest.getBik())
				.accountOfBank(counterpartyRequest.getAccountOfBank())
				.account(counterpartyRequest.getAccount())
				.locationIndex(counterpartyRequest.getLocationIndex())
				.eSubFederalUnit(ESubFederalUnit.valueOf(counterpartyRequest.getSubFederalUnit()))
				.region(counterpartyRequest.getRegion())
				.eSettlement(ESettlement.valueOf(counterpartyRequest.getSettlement()))
				.city(counterpartyRequest.getCity())
				.eStreetUnit(EStreetUnit.valueOf(counterpartyRequest.getStreetUnit()))
				.street(counterpartyRequest.getStreet())
				.eHouseUnit(EHouseUnit.valueOf(counterpartyRequest.getHouseUnit()))
				.house(counterpartyRequest.getHouse())
				.eAppartmentUnit(EAppartmentUnit.valueOf(counterpartyRequest.getAppartmentUnit()))
				.appartment(counterpartyRequest.getAppartment())
				.build();
		
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
