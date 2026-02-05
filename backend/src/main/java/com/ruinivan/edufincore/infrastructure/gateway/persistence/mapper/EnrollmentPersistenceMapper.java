package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import com.ruinivan.edufincore.domain.model.Enrollment;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.CourseEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.EnrollmentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;

public class EnrollmentPersistenceMapper {

  public EnrollmentEntity toEntity(Enrollment domainObj) {
    var entityBuilder = EnrollmentEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).enrollmentDate(domainObj.getEnrollmentDate())
        .status(domainObj.getStatus());

    StudentEntity studentRef = StudentEntity.builder().id(domainObj.getStudentId()).build();
    CourseEntity courseRef = CourseEntity.builder().id(domainObj.getCourseId()).build();

    return entityBuilder.student(studentRef).course(courseRef).build();
  }
}
