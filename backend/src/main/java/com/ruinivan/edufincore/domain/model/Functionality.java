package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Functionality extends Base {
  private String code;
  private String description;
  private String module;

  public Functionality(String code, String description, String module) {
    super();
    this.code = code;
    this.description = description;
    this.module = module;
  }

  public static Functionality restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String code,
      String description, String module) {
    return new Functionality(id, createdAt, updatedAt, code, description, module);
  }

  private Functionality(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String code, String description,
      String module) {
    super(id, createdAt, updatedAt);
    this.code = code;
    this.description = description;
    this.module = module;
  }

  public String getCode() {
    return this.code;
  }

  public String getDescription() {
    return this.description;
  }

  public String getModule() {
    return this.module;
  }
}
