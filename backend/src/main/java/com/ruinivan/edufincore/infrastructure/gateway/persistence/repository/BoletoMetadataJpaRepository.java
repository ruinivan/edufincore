package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.BoletoMetadataEntity;

public interface BoletoMetadataJpaRepository extends JpaRepository<BoletoMetadataEntity, UUID> {
  Optional<BoletoMetadataEntity> findByTuitionId(String tuitionId);
}
