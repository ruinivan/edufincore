package com.ruinivan.edufincore.infrastructure.gateway;

import com.ruinivan.edufincore.application.gateway.TuitionGateway;
import com.ruinivan.edufincore.domain.model.Tuition;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.TuitionEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.TuitionPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.TuitionJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class TuitionRepositoryAdapter implements TuitionGateway {

    private final TuitionJpaRepository jpaRepository;
    private final TuitionPersistenceMapper mapper;

    @Override
    @Transactional
    public Tuition save(Tuition tuition) {
        TuitionEntity entity = mapper.toEntity(tuition);

        TuitionEntity savedEntity = jpaRepository.save(entity);

        return mapper.toDomain(savedEntity);
    }
}