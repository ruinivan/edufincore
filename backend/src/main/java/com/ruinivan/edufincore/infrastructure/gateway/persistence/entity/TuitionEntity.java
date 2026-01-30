package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import com.ruinivan.edufincore.domain.model.TuitionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_TUITION")
@Data // Lombok gera Getters/Setters/Equals/HashCode
@NoArgsConstructor
@AllArgsConstructor
public class TuitionEntity {

    @Id
    private UUID id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TuitionStatus status;
}