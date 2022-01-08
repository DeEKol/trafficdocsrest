package com.deekol.trafficdocsrest.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deekol.trafficdocsrest.domain.ContractorEntity;
import com.deekol.trafficdocsrest.repository.ContractorRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/contractor")
@AllArgsConstructor
public class ContractorController {
	private final ContractorRepository contractorRepository;
	
	@GetMapping
	public List<ContractorEntity> list() {
		return contractorRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ContractorEntity getOne(@PathVariable("id") ContractorEntity contractor) {
		return contractor;
	}
	
	@PostMapping
	public ContractorEntity create(@RequestBody ContractorEntity contractor) {
		return contractorRepository.save(contractor);
	}
	
	@PutMapping("{id}")
	public ContractorEntity update(@PathVariable("id") ContractorEntity contractorFromDb, ContractorEntity contractor) {
		BeanUtils.copyProperties(contractor, contractorFromDb, "id");
		return contractorRepository.save(contractor);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") ContractorEntity contractor) {
		contractorRepository.delete(contractor);
	}
}
