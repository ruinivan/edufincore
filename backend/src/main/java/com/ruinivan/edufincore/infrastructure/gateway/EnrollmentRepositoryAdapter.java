package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.EnrollmentGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.EnrollmentPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.EnrollmentJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class EnrollmentRepositoryAdapter implements EnrollmentGateway {

  private final EnrollmentPersistenceMapper mapper;
  private final EnrollmentJpaRepository repository;
}
