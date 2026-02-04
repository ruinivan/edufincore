package com.ruinivan.edufincore.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment extends Base {
  private UUID tuitionId;
  private BigDecimal amountPaid;
  private PaymentMethod paymentMethod;
  private String bankTransactionId;
  private LocalDateTime occurredAt;

  public Payment(UUID tuitionId, BigDecimal amountPaid, PaymentMethod paymentMethod, String bankTransactionId,
      LocalDateTime occurredAt) {
    super();
    this.tuitionId = tuitionId;
    this.amountPaid = amountPaid;
    this.paymentMethod = paymentMethod;
    this.bankTransactionId = bankTransactionId;
    this.occurredAt = occurredAt;
  }

  public static Payment restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID tuitionId,
      BigDecimal amountPaid,
      PaymentMethod paymentMethod, String bankTransactionId,
      LocalDateTime occurredAt) {
    return new Payment(id, createdAt, updatedAt, tuitionId, amountPaid, paymentMethod, bankTransactionId, occurredAt);
  }

  private Payment(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID tuitionId, BigDecimal amountPaid,
      PaymentMethod paymentMethod, String bankTransactionId,
      LocalDateTime occurredAt) {
    super(id, createdAt, updatedAt);
    this.tuitionId = tuitionId;
    this.amountPaid = amountPaid;
    this.paymentMethod = paymentMethod;
    this.bankTransactionId = bankTransactionId;
    this.occurredAt = occurredAt;
  }

  public UUID getTuitionId() {
    return this.tuitionId;
  }

  public BigDecimal getAmountPaid() {
    return this.amountPaid;
  }

  public PaymentMethod getPaymentMethod() {
    return this.paymentMethod;
  }

  public String getBankTransactionId() {
    return this.bankTransactionId;
  }

  public LocalDateTime getOccurredAt() {
    return this.occurredAt;
  }
}
