package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.Role;
import com.ruinivan.edufincore.domain.model.User;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.RoleEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserPersistenceMapper {

  private final RolePersistenceMapper rolePersistenceMapper;

  public UserEntity toEntity(User domainObj) {
    if (domainObj == null) {
      return null;
    }

    StudentEntity studentRef = StudentEntity.builder().id(domainObj.getStudentId()).build();

    Set<RoleEntity> roleEntities = domainObj.getRoles() == null ? Collections.emptySet()
        : domainObj.getRoles().stream().map(rolePersistenceMapper::toEntity).collect(Collectors.toSet());

    return UserEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).username(domainObj.getUsername()).password(domainObj.getPassword())
        .student(studentRef).roles(roleEntities).build();
  }

  public User toDomain(UserEntity entity) {
    if (entity == null) {
      return null;
    }

    UUID studentId = entity.getStudent() == null ? null : entity.getStudent().getId();

    Set<Role> roles = entity.getRoles() == null ? Collections.emptySet()
        : entity.getRoles().stream().map(rolePersistenceMapper::toDomain).collect(Collectors.toSet());

    return User.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getUsername(),
        entity.getPassword(), studentId, roles);
  }
}
