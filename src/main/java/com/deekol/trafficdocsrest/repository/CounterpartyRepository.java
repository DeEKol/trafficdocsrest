package com.deekol.trafficdocsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.trafficdocsrest.domain.CounterpartyEntity;

public interface CounterpartyRepository extends JpaRepository<CounterpartyEntity, Long> {
	CounterpartyEntity findByName(String name);
}
