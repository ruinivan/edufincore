package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.CnabFileControlGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.CnabFileControlPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.CnabFileControlJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class CnabFileControlRepositoryAdapter implements CnabFileControlGateway {

  private final CnabFileControlPersistenceMapper mapper;
  private final CnabFileControlJpaRepository repository;
}
