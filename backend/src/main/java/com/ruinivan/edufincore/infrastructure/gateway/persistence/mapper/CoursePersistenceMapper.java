package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.Course;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.CourseEntity;

@Component
public class CoursePersistenceMapper {

  public CourseEntity toEntity(Course domainObj) {
    if (domainObj == null) {
      return null;
    }

    return CourseEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).name(domainObj.getName()).code(domainObj.getCode())
        .semesterPrice(domainObj.getSemesterPrice()).totalInstallments(domainObj.getTotalInstallments()).build();
  }

  public Course toDomain(CourseEntity entity) {
    if (entity == null) {
      return null;
    }

    return Course.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getName(),
        entity.getCode(), entity.getSemesterPrice(), entity.getTotalInstallments());
  }
}
