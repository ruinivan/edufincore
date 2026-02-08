package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.PaymentGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.PaymentPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.PaymentJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentRepositoryAdapter implements PaymentGateway {

  private final PaymentPersistenceMapper mapper;
  private final PaymentJpaRepository repository;
}
