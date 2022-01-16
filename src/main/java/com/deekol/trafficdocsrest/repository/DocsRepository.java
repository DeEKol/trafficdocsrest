package com.deekol.trafficdocsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.trafficdocsrest.domain.DocsEntity;

public interface DocsRepository extends JpaRepository<DocsEntity, Long> {
}
