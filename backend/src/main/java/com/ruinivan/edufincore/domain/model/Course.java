package com.ruinivan.edufincore.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Course extends Base {
  private String name;
  private String code;
  private BigDecimal semesterPrice;
  private Integer totalInstallments;

  public Course(String name, String code, BigDecimal semesterPrice, Integer totalInstallments) {
    super();
    this.name = name;
    this.code = code;
    this.semesterPrice = semesterPrice;
    this.totalInstallments = totalInstallments;
  }

  public static Course restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String code,
      BigDecimal semesterPrice, Integer totalInstallments) {
    return new Course(id, createdAt, updatedAt, name, code, semesterPrice, totalInstallments);
  }

  private Course(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String code,
      BigDecimal semesterPrice, Integer totalInstallments) {
    super(id, createdAt, updatedAt);
    this.name = name;
    this.code = code;
    this.semesterPrice = semesterPrice;
    this.totalInstallments = totalInstallments;
  }

  public String getName() {
    return this.name;
  }

  public String getCode() {
    return this.code;
  }

  public BigDecimal getSemesterPrice() {
    return this.semesterPrice;
  }

  public Integer getTotalInstallments() {
    return this.totalInstallments;
  }
}
