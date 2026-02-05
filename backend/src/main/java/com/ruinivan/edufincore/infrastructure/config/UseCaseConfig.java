package com.ruinivan.edufincore.infrastructure.config;

import com.ruinivan.edufincore.application.gateway.AuditLogGateway;
import com.ruinivan.edufincore.application.gateway.StudentGateway;
import com.ruinivan.edufincore.application.gateway.TuitionGateway;
import com.ruinivan.edufincore.application.usecase.CreateAuditLogImpl;
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

    @Bean
    public CreateAuditLogImpl createAuditLogImpl(AuditLogGateway gateway) {
        return new CreateAuditLogImpl(gateway);
    }

    @Bean
    public CreateStudentImpl createStudentImpl(StudentGateway gateway) {
        return new CreateStudentImpl(gateway);
    }

    @Bean
    @Primary
    public CreateStudent createStudentUseCase(CreateStudentImpl simpleUseCase) {
        return new TransactionalCreateStudent(simpleUseCase);
    }

    @Bean
    public CreateTuitionImpl createTuitionImpl(TuitionGateway gateway) {
        return new CreateTuitionImpl(gateway);
    }

    @Bean
    @Primary
    public CreateTuition createTuitionUseCase(CreateTuitionImpl simpleUseCase) {
        return new TransactionalCreateTuition(simpleUseCase);
    }
}