package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_ROLE", indexes = {
    @Index(name = "IDX_ROLE_NAME", columnList = "name", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends BaseEntity {

  @Column(nullable = false, unique = true, length = 50)
  private String name; // Ex: "ROLE_SECRETARY", "ROLE_FINANCIAL_MANAGER"

  @Column(length = 255)
  private String description;

  @Column(nullable = false)
  private boolean active; // Para desativar um perfil sem apagar

  // Relacionamento Muitos-para-Muitos: Uma Role tem Várias Funcionalidades
  // FetchType.EAGER é aceitável aqui pois roles não têm milhares de permissões,
  // e precisamos disso carregado no login.
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "TB_ROLE_FUNCTIONALITIES", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "functionality_id"))
  private Set<FunctionalityEntity> functionalities = new HashSet<>();
}