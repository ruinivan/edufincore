package com.ruinivan.edufincore.application.usecase;

import java.util.Optional;
import java.util.UUID;

import com.ruinivan.edufincore.domain.model.BoletoMetadata;

public interface FindBoletoMetadataByTuitionId {
  Optional<BoletoMetadata> execute(UUID tuitionId);
}
