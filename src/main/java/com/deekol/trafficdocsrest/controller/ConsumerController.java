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

import com.deekol.trafficdocsrest.domain.ConsumerEntity;
import com.deekol.trafficdocsrest.repository.ConsumerRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/participant")
@AllArgsConstructor
public class ConsumerController {
	private final ConsumerRepository consumerRepository;
	
	@GetMapping
	public List<ConsumerEntity> list() {
		return consumerRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ConsumerEntity getOne(@PathVariable("id") ConsumerEntity consumer) {
		return consumer;
	}
	
	@PostMapping
	public ConsumerEntity create(@RequestBody ConsumerEntity consumer) {
		return consumerRepository.save(consumer);
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
