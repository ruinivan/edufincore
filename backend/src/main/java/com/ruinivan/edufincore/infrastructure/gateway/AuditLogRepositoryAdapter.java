package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.AuditLogGateway;
import com.ruinivan.edufincore.domain.model.AuditLog;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.AuditLogEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.AuditLogPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.AuditLogJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuditLogRepositoryAdapter implements AuditLogGateway {

  private final AuditLogPersistenceMapper mapper;
  private final AuditLogJpaRepository repository;

  @Override
  public AuditLog save(AuditLog log) {
    AuditLogEntity entity = mapper.toEntity(log);

    AuditLogEntity savedEntity = repository.save(entity);

    return mapper.toDomain(savedEntity);
  }

}
