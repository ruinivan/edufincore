package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.Functionality;
import com.ruinivan.edufincore.domain.model.Role;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.FunctionalityEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.RoleEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RolePersistenceMapper {
  private final FunctionalityPersistenceMapper functionalityMapper;

  public RoleEntity toEntity(Role domainObj) {
    if (domainObj == null) {
      return null;
    }

    Set<FunctionalityEntity> functionalityEntities = domainObj.getFunctionalities() == null ? Collections.emptySet()
        : domainObj.getFunctionalities().stream().map(functionalityMapper::toEntity).collect(Collectors.toSet());

    return RoleEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).name(domainObj.getName()).description(domainObj.getDescription())
        .active(domainObj.isActive()).functionalities(functionalityEntities).build();
  }

  public Role toDomain(RoleEntity entity) {
    if (entity == null) {
      return null;
    }

    Set<Functionality> functionalities = entity.getFunctionalities().stream().map(functionalityMapper::toDomain)
        .collect(Collectors.toSet());

    return Role.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getName(),
        entity.getDescription(), entity.isActive(), functionalities);
  }
}
