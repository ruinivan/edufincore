package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.CnabFileControlEntity;

public interface CnabFileControlJpaRepository extends JpaRepository<CnabFileControlEntity, UUID> {

}
