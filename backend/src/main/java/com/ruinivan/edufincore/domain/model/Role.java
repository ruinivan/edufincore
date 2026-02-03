package com.ruinivan.edufincore.domain.model;

public class Role extends Base {
  private String name;
  private String description;
  private boolean active;

  public Role(String name, String description, boolean active) {
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
