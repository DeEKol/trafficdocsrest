package com.deekol.trafficdocsrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deekol.trafficdocsrest.domain.ConsumerEntity;
import com.deekol.trafficdocsrest.domain.enums.EAppartmentUnit;
import com.deekol.trafficdocsrest.domain.enums.EBusinessStructure;
import com.deekol.trafficdocsrest.domain.enums.EHouseUnit;
import com.deekol.trafficdocsrest.domain.enums.ESettlement;
import com.deekol.trafficdocsrest.domain.enums.EStreetUnit;
import com.deekol.trafficdocsrest.domain.enums.ESubFederalUnit;
import com.deekol.trafficdocsrest.payload.request.ConsumerRequest;
import com.deekol.trafficdocsrest.repository.ConsumerRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/consumer")
@AllArgsConstructor
public class ConsumerController {
	private final ConsumerRepository consumerRepository;
	
	@GetMapping
	public List<ConsumerEntity> getAll() {
		return consumerRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ConsumerEntity getOne(@PathVariable("id") ConsumerEntity consumer) {
		return consumer;
	}
	
	@PostMapping
	public ConsumerEntity create(@Valid @RequestBody ConsumerRequest consumerRequest) {
		EBusinessStructure eBusinessStructure = EBusinessStructure.valueOf(consumerRequest.getBusinessStructure());
		EBusinessStructure eBusinessStructureBank = EBusinessStructure.valueOf(consumerRequest.getBusinessStructureBank());
		ESubFederalUnit eSubFederalUnit = ESubFederalUnit.valueOf(consumerRequest.getSubFederalUnit());
		ESettlement eSettlement = ESettlement.valueOf(consumerRequest.getSettlement());
		EStreetUnit eStreetUnit = EStreetUnit.valueOf(consumerRequest.getStreetUnit());
		EHouseUnit eHouseUnit = EHouseUnit.valueOf(consumerRequest.getHouseUnit());
		EAppartmentUnit eAppartmentUnit = EAppartmentUnit.valueOf(consumerRequest.getAppartmentUnit());
		
		ConsumerEntity consumerEntity = new ConsumerEntity(	eBusinessStructure,
															consumerRequest.getName(),
															consumerRequest.getEmail(),
															consumerRequest.getInn(),
															consumerRequest.getKpp(),
															eBusinessStructureBank,
															consumerRequest.getBank(),
															consumerRequest.getBik(),
															consumerRequest.getAccountOfBank(),
															consumerRequest.getAccount(),
															consumerRequest.getLocationIndex(),
															eSubFederalUnit,
															consumerRequest.getRegion(),
															eSettlement,
															consumerRequest.getCity(),
															eStreetUnit,
															consumerRequest.getStreet(),
															eHouseUnit,
															consumerRequest.getHouse(),
															eAppartmentUnit,
															consumerRequest.getAppartment()
												);
		
		return consumerRepository.save(consumerEntity);
	}
	
	@PutMapping("{id}")
	public ConsumerEntity update(@PathVariable("id") ConsumerEntity consumerFromDb, ConsumerEntity consumer) {
		BeanUtils.copyProperties(consumer, consumerFromDb, "id");
		return consumerRepository.save(consumer);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") ConsumerEntity consumer) {
		consumerRepository.delete(consumer);
	}
}
