package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.NotificationLog;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.NotificationLogEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;

@Component
public class NotificationLogPersistenceMapper {

  public NotificationLogEntity toEntity(NotificationLog domainObj) {
    if (domainObj == null) {
      return null;
    }

    var entityBuilder = NotificationLogEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).recipient(domainObj.getRecipient()).subject(domainObj.getSubject())
        .channel(domainObj.getChannel()).status(domainObj.getStatus()).errorMessage(domainObj.getErrorMessage());

    StudentEntity studentRef = StudentEntity.builder().id(domainObj.getStudentId()).build();

    return entityBuilder.student(studentRef).build();
  }

  public NotificationLog toDomain(NotificationLogEntity entity) {
    if (entity == null) {
      return null;
    }

    return NotificationLog.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getRecipient(),
        entity.getSubject(), entity.getChannel(), entity.getStatus(), entity.getErrorMessage(),
        entity.getStudent().getId());
  }
}
