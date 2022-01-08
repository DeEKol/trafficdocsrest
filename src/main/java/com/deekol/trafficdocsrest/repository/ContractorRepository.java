package com.deekol.trafficdocsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.trafficdocsrest.domain.ContractorEntity;

public interface ContractorRepository extends JpaRepository<ContractorEntity, Long> {

}
