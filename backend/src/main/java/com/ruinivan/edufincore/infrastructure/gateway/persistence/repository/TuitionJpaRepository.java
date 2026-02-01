package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.TuitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TuitionJpaRepository extends JpaRepository<TuitionEntity, UUID> {
}