package com.deekol.trafficdocsrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deekol.trafficdocsrest.domain.TripEntity;

public interface TripRepository extends JpaRepository<TripEntity, Long> {
	
	@Query(value = "SELECT * FROM trip t WHERE t.docs_id = :docsId",
			nativeQuery = true)
	List<TripEntity> findTripByDocsId(@Param("docsId") Long docsId);
}
