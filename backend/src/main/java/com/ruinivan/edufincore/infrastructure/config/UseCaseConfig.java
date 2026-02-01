package com.ruinivan.edufincore.infrastructure.config;

import com.ruinivan.edufincore.application.gateway.StudentGateway;
import com.ruinivan.edufincore.application.gateway.TuitionGateway;
import com.ruinivan.edufincore.application.usecase.CreateStudent;
import com.ruinivan.edufincore.application.usecase.CreateStudentImpl;
import com.ruinivan.edufincore.application.usecase.CreateTuition;
import com.ruinivan.edufincore.application.usecase.CreateTuitionImpl;
import com.ruinivan.edufincore.infrastructure.gateway.transaction.TransactionalCreateStudent;
import com.ruinivan.edufincore.infrastructure.gateway.transaction.TransactionalCreateTuition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UseCaseConfig {

    // 1. Cria o Puro (ninguém de fora vê esse bean, por isso não precisa ser
    // público se não quiser)
    @Bean
    private CreateTuitionImpl createTuitionImpl(TuitionGateway gateway) {
        return new CreateTuitionImpl(gateway);
    }

    // 2. Cria o Transacional (Envolvendo o Puro)
    // Quando o Controller pedir "CreateTuition", o Spring vai entregar ESSE aqui.
    @Bean
    @Primary // Garante que este seja o escolhido se houver dúvida
    public CreateTuition createTuitionUseCase(CreateTuitionImpl simpleUseCase) {
        return new TransactionalCreateTuition(simpleUseCase);
    }

    @Bean
    private CreateStudentImpl createStudentImpl(StudentGateway gateway) {
        return new CreateStudentImpl(gateway);
    }

    @Bean
    @Primary
    public CreateStudent createStudentUseCase(CreateStudentImpl simpleUseCase) {
        return new TransactionalCreateStudent(simpleUseCase);
    }
}