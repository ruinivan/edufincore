package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.CourseEntity;

public interface CourseJpaRepository extends JpaRepository<CourseEntity, UUID> {

}
