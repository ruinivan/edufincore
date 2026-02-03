package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_STUDENT", indexes = {
        @Index(name = "IDX_STUDENT_CPF", columnList = "cpf", unique = true),
        @Index(name = "IDX_STUDENT_EMAIL", columnList = "email")
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class StudentEntity extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false, length = 150)
    private String email;

    @Builder.Default
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EnrollmentEntity> enrollments = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<WalletTransactionEntity> walletTransactions = new ArrayList<>();
}