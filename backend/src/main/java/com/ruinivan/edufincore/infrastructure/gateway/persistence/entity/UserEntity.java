package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_USER", indexes = {
    @Index(name = "IDX_USER_USERNAME", columnList = "username", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id")
  private StudentEntity student;

  // Muitos Usuários podem ter Muitas Roles (ex: Aluno e Monitor ao mesmo tempo)
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "TB_USER_ROLES", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<RoleEntity> roles = new HashSet<>();

  // Método auxiliar para pegar todas as permissões planas (flatMap)
  // Isso será usado pelo Spring Security para montar o UserDetails
  public Set<String> getAuthoritiesCode() {
    Set<String> authorities = new HashSet<>();
    for (RoleEntity role : roles) {
      if (role.isActive()) {
        for (FunctionalityEntity func : role.getFunctionalities()) {
          authorities.add(func.getCode());
        }
      }
    }
    return authorities;
  }
}