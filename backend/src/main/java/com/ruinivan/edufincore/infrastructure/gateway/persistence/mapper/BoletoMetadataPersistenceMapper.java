package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.BoletoMetadata;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.BoletoMetadataEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.TuitionEntity;

@Component
public class BoletoMetadataPersistenceMapper {

  public BoletoMetadataEntity toEntity(BoletoMetadata domainObj) {
    if (domainObj == null) {
      return null;
    }

    TuitionEntity tuitionRef = TuitionEntity.builder()
        .id(domainObj.getTuitionId())
        .build();

    return BoletoMetadataEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).nossoNumero(domainObj.getNossoNumero())
        .digitableLine(domainObj.getDigitableLine()).barcode(domainObj.getBarcode()).bankCode(domainObj.getBankCode())
        .documentNumber(domainObj.getDocumentNumber()).registeredAtBank(domainObj.isRegisteredAtBank())
        .tuition(tuitionRef).build();

  }

  public BoletoMetadata toDomain(BoletoMetadataEntity entity) {
    if (entity == null) {
      return null;
    }

    UUID tuitionId = entity.getTuition() == null ? null : entity.getTuition().getId();

    return BoletoMetadata.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(),
        tuitionId, entity.getNossoNumero(), entity.getDigitableLine(), entity.getBarcode(),
        entity.getBankCode(), entity.getDocumentNumber(), entity.isRegisteredAtBank());
  }

}
