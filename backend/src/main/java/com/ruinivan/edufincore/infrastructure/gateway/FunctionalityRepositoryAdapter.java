package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.FunctionalityGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.FunctionalityPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.FunctionalityJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class FunctionalityRepositoryAdapter implements FunctionalityGateway {

  private final FunctionalityPersistenceMapper mapper;
  private final FunctionalityJpaRepository repository;
}
