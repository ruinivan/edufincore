package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.RoleGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.RolePersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.RoleJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryAdapter implements RoleGateway {

  private final RolePersistenceMapper mapper;
  private final RoleJpaRepository repository;
}
