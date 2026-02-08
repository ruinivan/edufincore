package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User extends Base {
  private String username;
  private String password;
  private UUID studentId;
  private Set<Role> roles;

  public User(String username, String password, UUID studentId) {
    super();
    this.username = username;
    this.password = password;
    this.studentId = studentId;
    this.roles = new HashSet<>();
  }

  public static User restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String username,
      String password,
      UUID studentId, Set<Role> roles) {
    return new User(id, createdAt, updatedAt, username, password, studentId, roles);
  }

  private User(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String username, String password,
      UUID studentId, Set<Role> roles) {
    super(id, createdAt, updatedAt);
    this.username = username;
    this.password = password;
    this.studentId = studentId;
    this.roles = roles;
  }

  public void addRole(Role role) {
    if (this.roles == null) {
      this.roles = new HashSet<>();
    }
    this.roles.add(role);
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

  public Set<Role> getRoles() {
    return this.roles;
  }
}
