package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.UserGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.UserPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.UserJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryAdapter implements UserGateway {

  private final UserPersistenceMapper mapper;
  private final UserJpaRepository repository;
}
