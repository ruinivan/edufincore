package com.ruinivan.edufincore.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Tuition extends Base {
    private UUID enrollmentId;
    private BigDecimal amount;
    private BigDecimal discountValue;
    private BigDecimal penaltyValue;
    private BigDecimal finalValue;
    private LocalDate dueDate;
    private LocalDate paymenDate;
    private TuitionStatus status;

    public Tuition(UUID enrollmentId, BigDecimal amount, BigDecimal discountValue, BigDecimal penaltyValue,
            BigDecimal finalValue, LocalDate dueDate) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Tuition amount must be positive");
        }
        this.enrollmentId = enrollmentId;
        this.amount = amount;
        this.discountValue = discountValue;
        this.penaltyValue = penaltyValue;
        this.finalValue = finalValue;
        this.dueDate = dueDate;
        this.status = TuitionStatus.PENDING;
    }

    // Regra de Negócio Pura: O cálculo mora aqui, não no Service do Spring
    public BigDecimal calculateTotalAmount(LocalDate paymentDate) {
        if (paymentDate.isBefore(dueDate) || paymentDate.isEqual(dueDate)) {
            return this.amount;
        }

        long daysOverdue = ChronoUnit.DAYS.between(dueDate, paymentDate);

        // Multa fixa de 2%
        BigDecimal fine = this.amount.multiply(new BigDecimal("0.02"));

        // Juros de 1% ao mês (0.033% ao dia simples para este MVP)
        // Senior Tip: Em produção real, usaria juros compostos ou tabela Price
        BigDecimal dailyInterestRate = new BigDecimal("0.00033");
        BigDecimal interest = this.amount
                .multiply(dailyInterestRate)
                .multiply(new BigDecimal(daysOverdue));

        return this.amount.add(fine).add(interest).setScale(2, RoundingMode.HALF_EVEN);
    }

    public void pay() {
        if (this.status == TuitionStatus.PAID) {
            throw new IllegalStateException("Tuition is already paid");
        }
        this.status = TuitionStatus.PAID;
    }

    public UUID getEnrollmentId() {
        return this.enrollmentId;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getDiscountValue() {
        return this.discountValue;
    }

    public BigDecimal getPenaltyValue() {
        return this.penaltyValue;
    }

    public BigDecimal getFinalValue() {
        return this.finalValue;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public LocalDate PaymenDate() {
        return this.paymenDate;
    }

    public TuitionStatus getStatus() {
        return this.status;
    }

}
