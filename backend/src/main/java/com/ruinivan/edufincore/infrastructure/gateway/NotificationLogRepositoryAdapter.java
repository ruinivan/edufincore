package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.NotificationLogGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.NotificationLogPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.NotificationLogJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationLogRepositoryAdapter implements NotificationLogGateway {

  private final NotificationLogPersistenceMapper mapper;
  private final NotificationLogJpaRepository repository;
}
