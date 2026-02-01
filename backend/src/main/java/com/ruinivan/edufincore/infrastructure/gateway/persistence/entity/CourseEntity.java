package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_COURSE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity extends BaseEntity {

  @Column(nullable = false, length = 150)
  private String name;

  @Column(nullable = false, length = 50)
  private String code; // Ex: ENGSOFT-2026-1

  @Column(nullable = false, precision = 18, scale = 2)
  private BigDecimal semesterPrice; // Valor cheio do semestre

  @Column(name = "total_installments", nullable = false)
  private Integer totalInstallments; // Ex: 6 mensalidades
}