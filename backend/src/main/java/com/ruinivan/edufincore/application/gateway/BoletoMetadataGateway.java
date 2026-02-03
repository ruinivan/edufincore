package com.ruinivan.edufincore.application.gateway;

import java.util.Optional;

import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.BoletoMetadataEntity;

public interface BoletoMetadataGateway {
  Optional<BoletoMetadataEntity> findByTuitionId(String tuitionId);
}
