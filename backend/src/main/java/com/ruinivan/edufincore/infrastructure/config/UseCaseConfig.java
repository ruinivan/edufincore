package com.ruinivan.edufincore.infrastructure.config;

import com.ruinivan.edufincore.application.gateway.TuitionGateway;
import com.ruinivan.edufincore.application.usecase.CreateTuitionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateTuitionUseCase createTuitionUseCase(TuitionGateway tuitionGateway) {
        return new CreateTuitionUseCase(tuitionGateway);
    }
}