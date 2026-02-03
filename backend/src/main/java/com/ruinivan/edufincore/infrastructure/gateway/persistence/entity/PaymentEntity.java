package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ruinivan.edufincore.domain.model.PaymentMethod;

@Entity
@Table(name = "TB_PAYMENT")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PaymentEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tuition_id", nullable = false)
    private TuitionEntity tuition;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal amountPaid;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, length = 20)
    private PaymentMethod paymentMethod; // BOLETO, PIX, CREDIT_CARD

    // Id da transação externa (Nosso Número do Boleto ou End-to-End ID do Pix)
    @Column(name = "bank_transaction_id", length = 100, nullable = false)
    private String bankTransactionId;

    @Column(nullable = false)
    private LocalDateTime occurredAt;
}