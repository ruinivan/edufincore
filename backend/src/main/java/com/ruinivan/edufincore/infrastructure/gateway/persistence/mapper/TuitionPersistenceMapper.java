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

    return TuitionEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).amount(domainObj.getAmount()).dueDate(domainObj.getDueDate())
        .status(domainObj.getStatus()).build();
  }

  public Tuition toDomain(TuitionEntity entity) {
    if (entity == null) {
      return null;
    }

    return new Tuition(entity.getEnrollment().getId(), entity.getAmount(), entity.getDiscountValue(),
        entity.getPenaltyValue(), entity.getFinalValue(), entity.getDueDate());
  }
}
