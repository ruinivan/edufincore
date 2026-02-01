package com.ruinivan.edufincore.infrastructure.gateway.persistence.repository;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, UUID> {
    
    // O Spring cria o SQL automaticamente baseado no nome do método:
    // SELECT * FROM TB_STUDENT WHERE CPF = ?
    Optional<StudentEntity> findByCpf(String cpf);
    
    boolean existsByCpf(String cpf);
}