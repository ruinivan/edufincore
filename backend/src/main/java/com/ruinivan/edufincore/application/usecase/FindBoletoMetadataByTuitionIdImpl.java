package com.ruinivan.edufincore.application.usecase;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ruinivan.edufincore.application.gateway.BoletoMetadataGateway;
import com.ruinivan.edufincore.domain.model.BoletoMetadata;

public class FindBoletoMetadataByTuitionIdImpl implements FindBoletoMetadataByTuitionId {

  private static final Logger log = LoggerFactory.getLogger(FindBoletoMetadataByTuitionIdImpl.class);

  private final BoletoMetadataGateway boletoMetadataGateway;

  public FindBoletoMetadataByTuitionIdImpl(BoletoMetadataGateway boletoMetadataGateway) {
    this.boletoMetadataGateway = boletoMetadataGateway;
  }

  @Override
  public Optional<BoletoMetadata> execute(UUID tuitionId) {
    return boletoMetadataGateway.findByTuitionId(tuitionId);
  }

}
