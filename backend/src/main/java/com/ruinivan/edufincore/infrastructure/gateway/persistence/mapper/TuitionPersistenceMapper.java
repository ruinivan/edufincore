package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.Tuition;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.TuitionEntity;

@Component
public class TuitionPersistenceMapper {

  public TuitionEntity toEntity(Tuition domainObj) {
    if (domainObj == null) {
      return null;
    }

    TuitionEntity entity = new TuitionEntity();

    entity.setId(domainObj.getId());
    entity.setAmount(domainObj.getAmount());
    entity.setDueDate(domainObj.getDueDate());
    entity.setStatus(domainObj.getStatus());

    return entity;
  }

  public Tuition toDomain(TuitionEntity entity) {
    if (entity == null) {
      return null;
    }

    return new Tuition(entity.getId(), entity.getAmount(), entity.getDueDate());
  }
}
