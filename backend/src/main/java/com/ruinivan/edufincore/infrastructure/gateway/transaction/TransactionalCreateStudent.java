package com.ruinivan.edufincore.infrastructure.gateway.transaction;

import org.springframework.transaction.annotation.Transactional;

import com.ruinivan.edufincore.application.usecase.CreateStudent;
import com.ruinivan.edufincore.domain.model.Student;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionalCreateStudent implements CreateStudent {
  private final CreateStudent actualUseCase;

  @Override
  @Transactional
  public Student execute(Student input) {
    return actualUseCase.execute(input);
  }
}
