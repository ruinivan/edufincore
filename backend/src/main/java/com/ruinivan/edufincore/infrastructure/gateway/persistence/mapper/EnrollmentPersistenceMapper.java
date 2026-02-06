package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.Enrollment;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.CourseEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.EnrollmentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;

@Component
public class EnrollmentPersistenceMapper {

  public EnrollmentEntity toEntity(Enrollment domainObj) {
    if (domainObj == null) {
      return null;
    }

    var entityBuilder = EnrollmentEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).enrollmentDate(domainObj.getEnrollmentDate())
        .status(domainObj.getStatus());

    StudentEntity studentRef = StudentEntity.builder().id(domainObj.getStudentId()).build();
    CourseEntity courseRef = CourseEntity.builder().id(domainObj.getCourseId()).build();

    return entityBuilder.student(studentRef).course(courseRef).build();
  }

  public Enrollment toDomain(EnrollmentEntity entity) {
    if (entity == null) {
      return null;
    }

    return Enrollment.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getStudent().getId(),
        entity.getCourse().getId(), entity.getEnrollmentDate(), entity.getStatus());
  }
}
