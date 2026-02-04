package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User extends Base {
  private String username;
  private String password;
  private UUID studentId;

  public User(String username, String password, UUID studentId) {
    super();
    this.username = username;
    this.password = password;
    this.studentId = studentId;
  }

  public static User restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String username,
      String password,
      UUID studentId) {
    return new User(id, createdAt, updatedAt, username, password, studentId);
  }

  private User(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String username, String password,
      UUID studentId) {
    super(id, createdAt, updatedAt);
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
