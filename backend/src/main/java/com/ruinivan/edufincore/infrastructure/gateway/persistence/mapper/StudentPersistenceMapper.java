package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import com.ruinivan.edufincore.domain.model.Student;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentPersistenceMapper {

    // Converte do Domínio (Regra de Negócio) para Infraestrutura (Banco)
    public StudentEntity toEntity(Student domainObj) {
        if (domainObj == null) {
            return null;
        }

        // Usamos o Builder. Não precisamos dar 'new' nem ter acesso ao construtor.
        return StudentEntity.builder()
                .name(domainObj.getName())
                .cpf(domainObj.getCpf())
                .email(domainObj.getEmail())
                // .enrollments(...) // Listas opcionais ou ignoradas
                .build();
    }

    // Converte de Infraestrutura (Banco) para Domínio (Regra de Negócio)
    public Student toDomain(StudentEntity entity) {
        if (entity == null) {
            return null;
        }

        // Reconstruindo o objeto de domínio rico
        return new Student(
                entity.getName(),
                entity.getCpf(),
                entity.getEmail());
    }
}