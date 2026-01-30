package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.TuitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaTuitionRepository extends JpaRepository<TuitionEntity, UUID> {
}