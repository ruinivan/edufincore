package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import com.ruinivan.edufincore.domain.model.Student;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StudentPersistenceMapper {

    // Converte do Domínio (Regra de Negócio) para Infraestrutura (Banco)
    public StudentEntity toEntity(Student domainObj) {
        if (domainObj == null) {
            return null;
        }

        // Note que criamos uma nova entidade ou atualizamos uma existente.
        // Aqui assumimos criação/atualização simples.
        StudentEntity entity = new StudentEntity();

        // Se o ID existir no domínio, passamos. Se não, o JPA gera (no caso de insert)
        // Cuidado: No DDD puro, o ID geralmente nasce no domínio, mas vamos manter
        // simples.
        entity.setId(domainObj.getId());
        entity.setName(domainObj.getName());
        entity.setCpf(domainObj.getCpf());
        entity.setEmail(domainObj.getEmail());

        // Não mapeamos a lista de Tuitions aqui para evitar Loop Infinito ou carga
        // desnecessária (Lazy Loading)
        return entity;
    }

    // Converte de Infraestrutura (Banco) para Domínio (Regra de Negócio)
    public Student toDomain(StudentEntity entity) {
        if (entity == null) {
            return null;
        }

        // Reconstruindo o objeto de domínio rico
        return new Student(
                entity.getId(),
                entity.getName(),
                entity.getCpf(),
                entity.getEmail());
    }
}