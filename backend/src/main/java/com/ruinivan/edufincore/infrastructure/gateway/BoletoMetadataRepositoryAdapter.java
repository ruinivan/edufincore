package com.ruinivan.edufincore.infrastructure.gateway;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.BoletoMetadataGateway;
import com.ruinivan.edufincore.domain.model.BoletoMetadata;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.BoletoMetadataPersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.BoletoMetadataJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BoletoMetadataRepositoryAdapter implements BoletoMetadataGateway {

  private final BoletoMetadataJpaRepository repository;
  private final BoletoMetadataPersistenceMapper mapper;

  @Override
  public Optional<BoletoMetadata> findByTuitionId(UUID tuitionId) {
    return repository.findByTuition_Id(tuitionId).map(mapper::toDomain);
  }

}
