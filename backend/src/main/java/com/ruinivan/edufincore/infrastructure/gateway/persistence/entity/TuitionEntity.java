package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import com.ruinivan.edufincore.domain.model.TuitionStatus; // Seu Enum do Domínio
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_TUITION", indexes = {
        @Index(name = "IDX_TUITION_STATUS", columnList = "status"), // Busca rápida por pendentes
        @Index(name = "IDX_TUITION_DUE_DATE", columnList = "due_date") // Relatórios por data
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class TuitionEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "enrollment_id", nullable = false)
    private EnrollmentEntity enrollment;

    @OneToOne(mappedBy = "tuition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BoletoMetadataEntity boletoMetadata;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal amount; // Valor Original

    @Column(name = "discount_value", precision = 18, scale = 2)
    private BigDecimal discountValue;

    @Column(name = "penalty_value", precision = 18, scale = 2)
    private BigDecimal penaltyValue;

    @Column(name = "final_value", precision = 18, scale = 2)
    private BigDecimal finalValue; // Valor calculado pago

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TuitionStatus status; // PENDING, PAID, LATE, CANCELLED
}