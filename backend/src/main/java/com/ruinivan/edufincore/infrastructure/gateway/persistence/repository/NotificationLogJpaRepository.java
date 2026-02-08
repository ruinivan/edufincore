package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.NotificationLogEntity;

public interface NotificationLogJpaRepository extends JpaRepository<NotificationLogEntity, UUID> {

}
