package com.ruinivan.edufincore.infrastructure.gateway.transaction;

import com.ruinivan.edufincore.application.dto.CreateTuitionDTO;
import com.ruinivan.edufincore.application.usecase.CreateTuition;
import com.ruinivan.edufincore.domain.model.Tuition;
import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

// Esta classe pertence à INFRAESTRUTURA
@RequiredArgsConstructor
public class TransactionalCreateTuition implements CreateTuition {

  private final CreateTuition actualUseCase; // O UseCase Puro

  @Override
  @Transactional // O Spring agora gerencia isso
  public Tuition execute(CreateTuitionDTO input) {
    Tuition result = actualUseCase.execute(input);

    return result;
  }
}