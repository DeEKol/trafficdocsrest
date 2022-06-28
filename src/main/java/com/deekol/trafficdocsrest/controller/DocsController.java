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

import com.deekol.trafficdocsrest.domain.DocsEntity;
import com.deekol.trafficdocsrest.payload.request.DocsRequest;
import com.deekol.trafficdocsrest.payload.response.DocsResponse;
import com.deekol.trafficdocsrest.payload.response.MessageResponse;
import com.deekol.trafficdocsrest.repository.CounterpartyRepository;
import com.deekol.trafficdocsrest.repository.DocsRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/docs")
@AllArgsConstructor
public class DocsController {
	private final DocsRepository docsRepository;
	private final CounterpartyRepository counterpartyRepository;
	
	@GetMapping
	public List<DocsResponse> getAll() {
		List<DocsEntity> docsEntityList = docsRepository.findAll();
		List<DocsResponse> docsResponseList = new ArrayList<>();
		
		for(DocsEntity docsEntity : docsEntityList) {
			
			DocsResponse docsResponse = DocsResponse.builder()
					.id(docsEntity.getId())
					.date(docsEntity.getDate())
					.post(docsEntity.getPost())
					.pay(docsEntity.getPay())
					.consumer(docsEntity.getCounterpartyEntityConsumer().getName())
					.contractor(docsEntity.getCounterpartyEntityContractor().getName())
					.build();
			
			docsResponseList.add(docsResponse);
		}
		
		return docsResponseList;
	}
	
	@GetMapping("{id}")
	public DocsResponse getOne(@PathVariable("id") DocsEntity docsEntity) {
		DocsResponse docsResponse = DocsResponse.builder()
				.id(docsEntity.getId())
				.date(docsEntity.getDate())
				.post(docsEntity.getPost())
				.pay(docsEntity.getPay())
				.consumer(docsEntity.getCounterpartyEntityConsumer().getName())
				.contractor(docsEntity.getCounterpartyEntityContractor().getName())
				.build();
		
		return docsResponse;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody DocsRequest docsRequest) {
		DocsEntity docsEntity = DocsEntity.builder()
				.date(docsRequest.getDate())
				.post(docsRequest.getPost())
				.pay(docsRequest.getPay())
				.counterpartyEntityConsumer(counterpartyRepository.findByName(docsRequest.getConsumer()))
				.counterpartyEntityContractor(counterpartyRepository.findByName(docsRequest.getContractor()))				
				.build();
		
		docsRepository.save(docsEntity);
		return ResponseEntity.ok(new MessageResponse("Docs added successfully!"));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") DocsEntity docsFromDb, @Valid @RequestBody DocsRequest docsRequest) {
		DocsEntity docsEntity = DocsEntity.builder()
				.date(docsRequest.getDate())
				.post(docsRequest.getPost())
				.pay(docsRequest.getPay())
				.counterpartyEntityConsumer(counterpartyRepository.findByName(docsRequest.getConsumer()))
				.counterpartyEntityContractor(counterpartyRepository.findByName(docsRequest.getContractor()))				
				.build();
		
		BeanUtils.copyProperties(docsEntity, docsFromDb, "id");
		docsRepository.save(docsFromDb);
		
		return ResponseEntity.ok(new MessageResponse("Docs updated successfully!"));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") DocsEntity docsEntity) {
		docsRepository.delete(docsEntity);
	}
}
