package com.ruinivan.edufincore.infrastructure.gateway;

import java.util.Optional;

import com.ruinivan.edufincore.application.gateway.BoletoMetadataGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.BoletoMetadataEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.BoletoMetadataJpaRepository;

public class BoletoMetadataRepositoryAdapter implements BoletoMetadataGateway {

  @Override
  public Optional<BoletoMetadataEntity> findByTuitionId(String tuitionId) {

  }

}
