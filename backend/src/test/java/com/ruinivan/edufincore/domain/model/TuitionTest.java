package com.ruinivan.edufincore.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class TuitionTest {
  @Test
    void shouldCalculateInterestCorrectlyWhenOverdue() {
        // DADO (Given) - Mensalidade de R$ 1000,00 vencida há 30 dias
        LocalDate dueDate = LocalDate.of(2026, 1, 1);
        Tuition tuition = new Tuition(UUID.randomUUID(), new BigDecimal("1000.00"), dueDate);
        
        // QUANDO (When) - O aluno paga dia 31/01 (30 dias de atraso)
        LocalDate paymentDate = LocalDate.of(2026, 1, 31);
        BigDecimal totalToPay = tuition.calculateTotalAmount(paymentDate);

        // ENTÃO (Then)
        // Valor Base: 1000
        // Multa (2%): 20
        // Juros (1% ao mes / 30 dias): 10
        // Total Esperado: 1030.00
        BigDecimal expected = new BigDecimal("1030.00");
        
        Assertions.assertEquals(expected, totalToPay);
    }
    
    @Test
    void shouldNotApplyFineOnDueDate() {
        LocalDate dueDate = LocalDate.now();
        Tuition tuition = new Tuition(UUID.randomUUID(), new BigDecimal("500.00"), dueDate);
        
        BigDecimal total = tuition.calculateTotalAmount(dueDate);
        
        Assertions.assertEquals(new BigDecimal("500.00"), total);
    }
}
