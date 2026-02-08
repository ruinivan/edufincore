package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.WalletTransactionGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.WalletTransactionPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.WalletTransactionJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class WalletTransactionRepositoryAdapter implements WalletTransactionGateway {

  private final WalletTransactionPersistenceMapper mapper;
  private final WalletTransactionJpaRepository repository;
}
