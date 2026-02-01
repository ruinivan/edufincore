package com.ruinivan.edufincore.infrastructure.gateway.transaction;

import com.ruinivan.edufincore.application.dto.CreateTuitionDTO;
import com.ruinivan.edufincore.application.usecase.CreateTuition;
import com.ruinivan.edufincore.domain.model.Tuition;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

import org.springframework.transaction.annotation.Transactional;

// Esta classe pertence à INFRAESTRUTURA
@RequiredArgsConstructor
public class TransactionalCreateTuition implements CreateTuition {

  private final CreateTuition actualUseCase; // O UseCase Puro

  @Override
  @Transactional // O Spring agora gerencia isso
  public Tuition execute(CreateTuitionDTO input) {
    // 1. Executa e salva (o Hibernate segura o flush)
    Tuition result = actualUseCase.execute(input);

    // 2. A Bomba explode DENTRO da transação
    // O Spring intercepta esse erro e faz ROLLBACK automático
    // if (input.amount().compareTo(new BigDecimal("9999")) == 0) {
    // throw new RuntimeException("🔥 ERRO FATAL SIMULADO! O BANCO DEVE FAZER
    // ROLLBACK! 🔥");
    // }

    return result;
  }
}