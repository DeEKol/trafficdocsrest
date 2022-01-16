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

import com.deekol.trafficdocsrest.domain.DocsEntity;
import com.deekol.trafficdocsrest.payload.request.DocsRequest;
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
	public List<DocsEntity> getAll() {
		return docsRepository.findAll();
	}
	
	@GetMapping("{id}")
	public DocsEntity getOne(@PathVariable("id") DocsEntity docsEntity) {
		return docsEntity;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody DocsRequest docsRequest) {
		DocsEntity docsEntity = new DocsEntity();
		
		docsEntity.setDate(docsRequest.getDate());
		docsEntity.setPost(docsRequest.getPost());
		docsEntity.setPay(docsRequest.getPay());
		
		docsEntity.setCounterpartyEntityConsumer(counterpartyRepository.findByName(docsRequest.getConsumer()));
		docsEntity.setCounterpartyEntityContractor(counterpartyRepository.findByName(docsRequest.getContractor()));
		
		docsRepository.save(docsEntity);
		
		return ResponseEntity.ok(new MessageResponse("Docs added successfully!"));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") DocsEntity docsFromDb, @Valid @RequestBody DocsRequest docsRequest) {
		DocsEntity docsEntity = new DocsEntity();
		
		docsEntity.setDate(docsRequest.getDate());
		docsEntity.setPost(docsRequest.getPost());
		docsEntity.setPay(docsRequest.getPay());
		
		docsEntity.setCounterpartyEntityConsumer(counterpartyRepository.findByName(docsRequest.getConsumer()));
		docsEntity.setCounterpartyEntityContractor(counterpartyRepository.findByName(docsRequest.getContractor()));
		
		
		BeanUtils.copyProperties(docsEntity, docsFromDb, "id");
		docsRepository.save(docsFromDb);
		
		return ResponseEntity.ok(new MessageResponse("Docs updated successfully!"));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") DocsEntity docsEntity) {
		docsRepository.delete(docsEntity);
	}
}
