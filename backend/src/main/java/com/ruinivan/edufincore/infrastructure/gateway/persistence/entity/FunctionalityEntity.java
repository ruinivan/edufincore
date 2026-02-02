package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_FUNCTIONALITY", indexes = {
    @Index(name = "IDX_FUNC_CODE", columnList = "code", unique = true)
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class FunctionalityEntity extends BaseEntity {

  @Column(nullable = false, unique = true, length = 50)
  private String code; // Ex: "STUDENT_CREATE", "FINANCIAL_REPORT_READ"

  @Column(nullable = false, length = 150)
  private String description; // Ex: "Permite cadastrar novos alunos"

  @Column(nullable = false, length = 50)
  private String module; // Ex: "ACADEMIC", "FINANCIAL", "ADMIN" (Para organizar a tela do front)
}