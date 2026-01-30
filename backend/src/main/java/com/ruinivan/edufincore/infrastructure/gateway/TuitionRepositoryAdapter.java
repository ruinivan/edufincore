package com.ruinivan.edufincore.infrastructure.gateway;

import com.ruinivan.edufincore.application.gateway.TuitionGateway;
import com.ruinivan.edufincore.domain.model.Tuition;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.TuitionEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.JpaTuitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TuitionRepositoryAdapter implements TuitionGateway {

    private final JpaTuitionRepository jpaRepository;

    @Override
    public Tuition save(Tuition tuition) {
        // 1. Mapeia Domínio -> Entity JPA
        TuitionEntity entity = new TuitionEntity(
            tuition.getId(),
            tuition.getAmount(),
            tuition.getDueDate(),
            tuition.getStatus() // Getters que você criou no domínio (ou Lombok se usou lá)
        );

        // 2. Salva no Oracle
        TuitionEntity savedEntity = jpaRepository.save(entity);

        // 3. Mapeia Entity JPA -> Domínio (Retorno)
        // Nota: Idealmente teríamos um Mapper dedicado aqui para não poluir o código
        return new Tuition(
            savedEntity.getId(),
            savedEntity.getAmount(),
            savedEntity.getDueDate()
        );
    }
}