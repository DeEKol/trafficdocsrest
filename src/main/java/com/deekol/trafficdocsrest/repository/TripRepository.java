package com.deekol.trafficdocsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.trafficdocsrest.domain.TripEntity;

public interface TripRepository extends JpaRepository<TripEntity, Long> {

}
