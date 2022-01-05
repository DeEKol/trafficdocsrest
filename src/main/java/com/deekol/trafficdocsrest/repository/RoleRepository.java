package com.deekol.trafficdocsrest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.trafficdocsrest.security.model.ERole;
import com.deekol.trafficdocsrest.security.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	Optional<RoleEntity> findByName(ERole name);
}
