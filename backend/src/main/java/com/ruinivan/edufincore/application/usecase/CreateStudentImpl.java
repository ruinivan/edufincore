package com.ruinivan.edufincore.application.usecase;

import com.ruinivan.edufincore.application.gateway.StudentGateway;
import com.ruinivan.edufincore.domain.exception.StudentAlreadyExistsException;
import com.ruinivan.edufincore.domain.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateStudentImpl implements CreateStudent {

  private static final Logger log = LoggerFactory.getLogger(CreateTuitionImpl.class);

  private final StudentGateway gateway;

  public CreateStudentImpl(StudentGateway gateway) {
    this.gateway = gateway;
  }

  // Removemos o @Transactional do Spring aqui para manter pureza.
  // (Abordaremos a transação no passo 3, pois isso é crucial em finanças)
  public Student execute(Student student) {
    log.info("Tentando criar estudante com CPF: {}", student.getCpf());

    if (gateway.existsByCpf(student.getCpf())) {
      log.warn("Tentativa de cadastro duplicado para CPF: {}", student.getCpf());
      throw new StudentAlreadyExistsException("Já existe um aluno matriculado com este CPF.");
    }

    return gateway.save(student);
  }
}