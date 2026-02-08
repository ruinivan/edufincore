package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.FunctionalityEntity;

public interface FunctionalityJpaRepository extends JpaRepository<FunctionalityEntity, UUID> {

}
