package com.deekol.trafficdocsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.trafficdocsrest.domain.ConsumerEntity;

public interface ConsumerRepository extends JpaRepository<ConsumerEntity, Long> {

}
