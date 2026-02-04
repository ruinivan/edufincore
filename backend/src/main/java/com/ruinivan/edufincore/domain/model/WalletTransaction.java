package com.ruinivan.edufincore.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class WalletTransaction extends Base {
  private UUID studentId;
  private BigDecimal amount;
  private WalletTransactionType type;
  private String description;
  private BigDecimal balanceAfter;
  private UUID originPayment;

  public WalletTransaction(UUID studentId, BigDecimal amount, WalletTransactionType type, String description,
      BigDecimal balanceAfter, UUID originPayment) {
    super();
    this.studentId = studentId;
    this.amount = amount;
    this.type = type;
    this.description = description;
    this.balanceAfter = balanceAfter;
    this.originPayment = originPayment;
  }

  public static WalletTransaction restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID studentId,
      BigDecimal amount, WalletTransactionType type, String description,
      BigDecimal balanceAfter, UUID originPayment) {
    return new WalletTransaction(id, createdAt, updatedAt, studentId, amount, type, description, balanceAfter,
        originPayment);
  }

  private WalletTransaction(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID studentId,
      BigDecimal amount, WalletTransactionType type, String description,
      BigDecimal balanceAfter, UUID originPayment) {
    super(id, createdAt, updatedAt);
    this.studentId = studentId;
    this.amount = amount;
    this.type = type;
    this.description = description;
    this.balanceAfter = balanceAfter;
    this.originPayment = originPayment;
  }

  public UUID getStudentId() {
    return this.studentId;
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public WalletTransactionType getType() {
    return this.type;
  }

  public String getDescription() {
    return this.description;
  }

  public BigDecimal getBalanceAfter() {
    return this.balanceAfter;
  }

  public UUID getOriginPayment() {
    return this.originPayment;
  }
}
