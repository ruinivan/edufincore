package com.ruinivan.edufincore.application.gateway;

import com.ruinivan.edufincore.domain.model.Tuition;

// Interface que a Infraestrutura DEVE implementar.
// O Application não sabe que existe JPA ou SQL.
public interface TuitionGateway {
    Tuition save(Tuition tuition);
    // Futuro: Optional<Tuition> findById(UUID id);
}