package com.deekol.trafficdocsrest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.deekol.trafficdocsrest.security.model.RefreshTokenEntity;
import com.deekol.trafficdocsrest.security.model.UserEntity;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {
	Optional<RefreshTokenEntity> findById(Long id);
	
	Optional<RefreshTokenEntity> findByToken(String token);
	
	@Modifying
	int deleteByUser(UserEntity user);
}
