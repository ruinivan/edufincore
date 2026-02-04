package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Role extends Base {
  private String name;
  private String description;
  private boolean active;

  public Role(String name, String description) {
    super();
    this.name = name;
    this.description = description;
    this.active = true;
  }

  public static Role restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String description,
      boolean active) {
    return new Role(id, createdAt, updatedAt, name, description, active);
  }

  private Role(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String description,
      boolean active) {
    super(id, createdAt, updatedAt);
    this.name = name;
    this.description = description;
    this.active = active;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public boolean isActive() {
    return this.active;
  }
}
