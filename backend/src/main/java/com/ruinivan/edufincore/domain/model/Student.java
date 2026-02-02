package com.ruinivan.edufincore.domain.model;

public class Student extends Base {

  private final String name;
  private final String cpf;
  private final String email;

  public Student(String name, String cpf, String email) {
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