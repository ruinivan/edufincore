package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_STUDENT", indexes = {
    @Index(name = "IDX_STUDENT_CPF", columnList = "cpf", unique = true),
    @Index(name = "IDX_STUDENT_EMAIL", columnList = "email")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, length = 150)
    private String email;

    // Relacionamento Opcional: Para carregar mensalidades do aluno
    // FetchType.LAZY é mandatório para performance. Nunca use EAGER em listas.
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TuitionEntity> tuitions = new ArrayList<>();
}