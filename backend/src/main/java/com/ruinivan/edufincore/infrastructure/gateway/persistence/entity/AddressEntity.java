package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id", nullable = false)
  private StudentEntity student;

  @Column(nullable = false, length = 8)
  private String zipCode; // CEP (apenas números)

  @Column(nullable = false, length = 150)
  private String street;

  @Column(nullable = false, length = 10)
  private String number;

  @Column(length = 50)
  private String complement;

  @Column(nullable = false, length = 100)
  private String district; // Bairro

  @Column(nullable = false, length = 100)
  private String city;

  @Column(nullable = false, length = 2)
  private String state; // UF (SP, DF, PR)

  @Column(nullable = false)
  private boolean mainAddress; // Define qual usar na cobrança
}