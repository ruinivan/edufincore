package com.ruinivan.edufincore.application.usecase;

import com.ruinivan.edufincore.application.dto.CreateTuitionDTO;
import com.ruinivan.edufincore.application.gateway.TuitionGateway;
import com.ruinivan.edufincore.domain.model.Tuition;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTuitionImpl implements CreateTuition {

    private static final Logger log = LoggerFactory.getLogger(CreateTuitionImpl.class);

    private final TuitionGateway tuitionGateway;

    // Injeção via Construtor (Padrão Sênior)
    public CreateTuitionImpl(TuitionGateway tuitionGateway) {
        this.tuitionGateway = tuitionGateway;
    }

    public Tuition execute(CreateTuitionDTO input) {
        // 1. Converte DTO -> Domínio
        Tuition newTuition = new Tuition(
                UUID.randomUUID(),
                input.amount(),
                input.dueDate());

        // 2. Chama a porta para salvar (Não sabemos onde vai salvar)
        return tuitionGateway.save(newTuition);
    }
}