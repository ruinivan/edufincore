package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.AddressEntity;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, UUID> {

}