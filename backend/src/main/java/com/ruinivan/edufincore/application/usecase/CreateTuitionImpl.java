package com.ruinivan.edufincore.application.usecase;

import com.ruinivan.edufincore.application.dto.CreateTuitionDTO;
import com.ruinivan.edufincore.application.gateway.TuitionGateway;
import com.ruinivan.edufincore.domain.model.Tuition;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTuitionImpl implements CreateTuition {

    private static final Logger log = LoggerFactory.getLogger(CreateTuitionImpl.class);

    private final TuitionGateway tuitionGateway;

    public CreateTuitionImpl(TuitionGateway tuitionGateway) {
        this.tuitionGateway = tuitionGateway;
    }

    @Override
    public Tuition execute(CreateTuitionDTO input) {
        log.info("Iniciando criação de mensalidade para Enrollment ID: {}", input.enrollmentId());

        // 1. Tratamento de Valores Opcionais (Null Safety)
        // Se o desconto vier nulo no DTO, transformamos em Zero para não quebrar a
        // matemática
        BigDecimal discount = input.discountValue() != null ? input.discountValue() : BigDecimal.ZERO;

        // Na criação, multa e valor final ainda não existem (ou são baseados no valor
        // inicial)
        BigDecimal penalty = BigDecimal.ZERO;
        BigDecimal finalValue = input.amount().subtract(discount); // Valor Líquido inicial

        // 2. Instanciação do Domínio
        // Usamos o construtor manual que valida as regras de negócio
        Tuition newTuition = new Tuition(
                input.enrollmentId(),
                input.amount(),
                discount,
                penalty,
                finalValue,
                input.dueDate());

        // 3. Persistência
        Tuition savedTuition = tuitionGateway.save(newTuition);

        log.info("Mensalidade criada com sucesso via Gateway. ID: {}", savedTuition.getId()); // Assumindo que Tuition
                                                                                              // herda getId de Base

        return savedTuition;
    }
}