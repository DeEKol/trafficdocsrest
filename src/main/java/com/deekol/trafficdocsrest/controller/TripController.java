package com.deekol.trafficdocsrest.controller;

import java.time.LocalDate;
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

import com.deekol.trafficdocsrest.domain.TripEntity;
import com.deekol.trafficdocsrest.repository.TripRepository;

@RestController
@RequestMapping("trip")
public class TripController {
private final TripRepository tripRepository;
	
	public TripController(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}
	
	@GetMapping
	public List<TripEntity> list() {
		return tripRepository.findAll();
	}
	
	@GetMapping("{id}")
	public TripEntity getOne(@PathVariable("id") TripEntity trip) {
		return trip;
	}
	
	@PostMapping
	public TripEntity create(@RequestBody TripEntity trip) {
		trip.setDate(LocalDate.now());
		return tripRepository.save(trip);
	}
	
	@PutMapping("{id}")
	public TripEntity update(@PathVariable("id") TripEntity tripFromDb, @RequestBody TripEntity trip) {
		BeanUtils.copyProperties(trip, tripFromDb, "id");
		return tripRepository.save(tripFromDb);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") TripEntity trip) {
		tripRepository.delete(trip);
	}
}