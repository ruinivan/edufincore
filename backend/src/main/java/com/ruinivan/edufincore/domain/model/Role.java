package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Role extends Base {
  private String name;
  private String description;
  private boolean active;
  private Set<Functionality> functionalities;

  public Role(String name, String description) {
    super();
    this.name = name;
    this.description = description;
    this.active = true;
    this.functionalities = new HashSet<>();
  }

  public static Role restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String description,
      boolean active, Set<Functionality> functionalities) {
    return new Role(id, createdAt, updatedAt, name, description, active, functionalities);
  }

  private Role(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String description,
      boolean active, Set<Functionality> functionalities) {
    super(id, createdAt, updatedAt);
    this.name = name;
    this.description = description;
    this.active = active;
    this.functionalities = functionalities;
  }

  public void addFunctionality(Functionality functionality) {
    if (this.functionalities == null) {
      this.functionalities = new HashSet<>();
    }
    this.functionalities.add(functionality);
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

  public Set<Functionality> getFunctionalities() {
    return this.functionalities;
  }
}
