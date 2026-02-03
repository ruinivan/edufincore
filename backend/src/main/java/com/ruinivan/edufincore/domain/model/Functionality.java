package com.ruinivan.edufincore.domain.model;

public class Functionality extends Base {
  private String code;
  private String description;
  private String module;

  public Functionality(String code, String description, String module) {
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
