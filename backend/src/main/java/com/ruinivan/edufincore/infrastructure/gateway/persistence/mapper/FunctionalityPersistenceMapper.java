package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.Functionality;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.FunctionalityEntity;

@Component
public class FunctionalityPersistenceMapper {

  public FunctionalityEntity toEntity(Functionality domainObj) {
    if (domainObj == null) {
      return null;
    }

    return FunctionalityEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).code(domainObj.getCode()).description(domainObj.getDescription())
        .module(domainObj.getModule()).build();
  }

  public Functionality toDomain(FunctionalityEntity entity) {
    if (entity == null) {
      return null;
    }

    return Functionality.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getCode(),
        entity.getDescription(), entity.getModule());
  }
}
