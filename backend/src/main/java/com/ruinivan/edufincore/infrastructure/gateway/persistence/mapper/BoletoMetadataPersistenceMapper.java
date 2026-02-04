package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

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

    var entityBuilder = BoletoMetadataEntity.builder().nossoNumero(domainObj.getNossoNumero())
        .digitableLine(domainObj.getDigitableLine()).barcode(domainObj.getBarcode()).bankCode(domainObj.getBankCode())
        .documentNumber(domainObj.getDocumentNumber()).registeredAtBank(domainObj.isRegisteredAtBank());

    if (domainObj.getTuitionId() != null) {
      TuitionEntity tuitionRef = TuitionEntity.builder()
          .id(domainObj.getTuitionId())
          .build();

      entityBuilder.tuition(tuitionRef);
    }

    return entityBuilder.build();
  }

  public BoletoMetadata toDomain(BoletoMetadataEntity entity) {
    if (entity == null) {
      return null;
    }

    return BoletoMetadata.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(),
        entity.getTuition().getId(), entity.getNossoNumero(), entity.getDigitableLine(), entity.getBarcode(),
        entity.getBankCode(), entity.getDocumentNumber(), entity.isRegisteredAtBank());
  }

}
