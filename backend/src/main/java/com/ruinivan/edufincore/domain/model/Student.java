package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Student extends Base {

  private final String name;
  private final String cpf;
  private final String email;

  public Student(String name, String cpf, String email) {
    super();
    this.name = name;
    this.cpf = cpf;
    this.email = email;
  }

  public static Student restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String cpf,
      String email) {
    return new Student(id, createdAt, updatedAt, name, cpf, email);
  }

  private Student(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String cpf, String email) {
    super(id, createdAt, updatedAt);
    this.name = name;
    this.cpf = cpf;
    this.email = email;
  }

  public String getName() {
    return this.name;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getEmail() {
    return this.email;
  }
}