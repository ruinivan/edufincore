package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.AddressGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.AddressPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.AddressJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddressRepositoryAdapter implements AddressGateway {

  private final AddressPersistenceMapper mapper;
  private final AddressJpaRepository repository;
}
