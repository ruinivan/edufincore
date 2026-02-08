package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.Enrollment;
import com.ruinivan.edufincore.domain.model.Tuition;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.CourseEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.EnrollmentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.TuitionEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EnrollmentPersistenceMapper {

  private final TuitionPersistenceMapper tuitionPersistenceMapper;

  public EnrollmentEntity toEntity(Enrollment domainObj) {
    if (domainObj == null) {
      return null;
    }

    StudentEntity studentRef = domainObj.getStudentId() == null ? null
        : StudentEntity.builder().id(domainObj.getStudentId()).build();
    CourseEntity courseRef = domainObj.getStudentId() == null ? null
        : CourseEntity.builder().id(domainObj.getCourseId()).build();
    List<TuitionEntity> tuitionEntitiesRef = domainObj.getTuitions().stream().map(tuitionPersistenceMapper::toEntity)
        .collect(Collectors.toList());

    return EnrollmentEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).enrollmentDate(domainObj.getEnrollmentDate())
        .status(domainObj.getStatus()).student(studentRef).course(courseRef).tuitions(tuitionEntitiesRef).build();
  }

  public Enrollment toDomain(EnrollmentEntity entity) {
    if (entity == null) {
      return null;
    }

    UUID studentId = entity.getStudent() == null ? null : entity.getStudent().getId();

    UUID courseId = entity.getCourse() == null ? null : entity.getCourse().getId();

    List<Tuition> tuitions = entity.getTuitions() == null ? null
        : entity.getTuitions().stream().map(tuitionPersistenceMapper::toDomain).collect(Collectors.toList());

    return Enrollment.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), studentId,
        courseId, entity.getEnrollmentDate(), entity.getStatus(), tuitions);
  }
}
