package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.AuditLog;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.AuditLogEntity;

@Component
public class AuditLogPersistenceMapper {

  public AuditLogEntity toEntity(AuditLog domainObj) {
    if (domainObj == null) {
      return null;
    }
    return AuditLogEntity.builder().id(domainObj.getId()).entityId(domainObj.getEntityId())
        .entityType(domainObj.getEntityType()).operation(domainObj.getOperation()).oldValue(domainObj.getOldValue())
        .newValue(domainObj.getNewValue()).timestamp(domainObj.getTimestamp()).userSystem(domainObj.getUserSystem())
        .build();
  }

  public AuditLog toDomain(AuditLogEntity entity) {
    if (entity == null) {
      return null;
    }
    return AuditLog.restore(entity.getId(), entity.getEntityId(), entity.getEntityType(), entity.getOperation(),
        entity.getOldValue(), entity.getNewValue(), entity.getTimestamp(), entity.getUserSystem());
  }
}
