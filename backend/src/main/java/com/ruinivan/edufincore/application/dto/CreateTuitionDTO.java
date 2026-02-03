package com.ruinivan.edufincore.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public record CreateTuitionDTO(

        @NotNull(message = "Enrollment ID is required") UUID enrollmentId, // <--- ADICIONADO: Obrigatório para vincular
                                                                           // a mensalidade

        @NotNull(message = "Amount is required") @DecimalMin(value = "0.01", message = "Amount must be greater than zero") BigDecimal amount,

        // Opcional: Desconto inicial (Bolsa, promoção, etc)
        // Se não vier, assumiremos ZERO no UseCase
        @DecimalMin(value = "0.00", message = "Discount cannot be negative") BigDecimal discountValue,

        @NotNull(message = "Due date is required") @FutureOrPresent(message = "Due date cannot be in the past") @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dueDate) {
}