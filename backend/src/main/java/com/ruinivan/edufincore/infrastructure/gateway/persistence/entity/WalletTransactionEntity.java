package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_WALLET_TRANSACTION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransactionEntity extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "student_id", nullable = false)
  private StudentEntity student;

  @Column(nullable = false, precision = 18, scale = 2)
  private BigDecimal amount;

  @Column(nullable = false, length = 10)
  private String type; // CREDIT, DEBIT

  @Column(nullable = false, length = 255)
  private String description; // "Reembolso pgto duplicado", "Abatimento mensalidade X"

  @Column(name = "balance_after", nullable = false, precision = 18, scale = 2)
  private BigDecimal balanceAfter; // Saldo após a transação (Snapshot)

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "origin_payment_id")
  private PaymentEntity originPayment; // Link opcional com o pagamento que gerou isso
}