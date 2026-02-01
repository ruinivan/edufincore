package com.ruinivan.edufincore.infrastructure.gateway;

import com.ruinivan.edufincore.application.gateway.StudentGateway; // Interface definida no Application/Domain layer
import com.ruinivan.edufincore.domain.model.Student;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.StudentPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.StudentJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor // Cria construtor para injeção de dependência (Lombok)
@Slf4j // Logs para monitoramento
public class StudentRepositoryAdapter implements StudentGateway {

    private final StudentJpaRepository jpaRepository;
    private final StudentPersistenceMapper mapper;

    @Override
    @Transactional // Garante que a transação do banco abra e feche aqui
    public Student save(Student student) {
        log.info("Iniciando persistência do estudante com CPF: {}", student.getCpf());
        
        // 1. Converte Domínio -> Entity
        StudentEntity entity = mapper.toEntity(student);
        
        // 2. Salva no Oracle via JPA
        StudentEntity savedEntity = jpaRepository.save(entity);
        
        // 3. Retorna convertido de volta para Domínio
        return mapper.toDomain(savedEntity);
    }

    @Override
    @Transactional(readOnly = true) // Otimiza performance no Oracle (não gera lock de escrita)
    public Optional<Student> findByCpf(String cpf) {
        // Busca Entity -> Converte -> Retorna Optional de Domínio
        return jpaRepository.findByCpf(cpf)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return jpaRepository.existsByCpf(cpf);
    }
}