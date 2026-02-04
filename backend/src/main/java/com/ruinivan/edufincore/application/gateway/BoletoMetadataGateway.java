package com.ruinivan.edufincore.application.gateway;

import java.util.Optional;
import java.util.UUID;

import com.ruinivan.edufincore.domain.model.BoletoMetadata;

public interface BoletoMetadataGateway {
  Optional<BoletoMetadata> findByTuitionId(UUID tuitionId);
}
