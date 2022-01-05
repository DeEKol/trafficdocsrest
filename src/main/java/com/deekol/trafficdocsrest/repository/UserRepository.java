package com.deekol.trafficdocsrest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deekol.trafficdocsrest.security.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
}
