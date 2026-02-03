package com.ruinivan.edufincore.domain.model;

import java.util.UUID;

public class User extends Base {
  private String username;
  private String password;
  private UUID studentId;

  public User(String username, String password, UUID studentId) {
    this.username = username;
    this.password = password;
    this.studentId = studentId;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public UUID getStudentId() {
    return this.studentId;
  }
}
