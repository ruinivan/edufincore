package com.ruinivan.edufincore.domain.model;

import java.util.UUID;

public class Student {

  private final UUID id;
  private final String name;
  private final String cpf;
  private final String email;

  public Student(UUID id, String name, String cpf, String email){
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.email = email;
  }

  public UUID getId(){return this.id;}
  public String getName(){return this.name;}
  public String getCpf(){return this.cpf;}
  public String getEmail(){return this.email;}
}