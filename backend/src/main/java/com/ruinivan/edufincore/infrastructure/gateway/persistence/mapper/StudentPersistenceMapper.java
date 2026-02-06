package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import com.ruinivan.edufincore.domain.model.Student;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentPersistenceMapper {

    public StudentEntity toEntity(Student domainObj) {
        if (domainObj == null) {
            return null;
        }

        return StudentEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
                .updatedAt(domainObj.getUpdatedAt())
                .name(domainObj.getName())
                .cpf(domainObj.getCpf())
                .email(domainObj.getEmail())
                .build();
    }

    public Student toDomain(StudentEntity entity) {
        if (entity == null) {
            return null;
        }

        return Student.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getName(),
                entity.getCpf(), entity.getEmail());
    }
}