package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.CnabFileControl;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.CnabFileControlEntity;

@Component
public class CnabFileControlPersistenceMapper {

  public CnabFileControlEntity toEntity(CnabFileControl domainObj) {
    if (domainObj == null) {
      return null;
    }

    return CnabFileControlEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).fileName(domainObj.getFileName()).fileType(domainObj.getFileType())
        .status(domainObj.getStatus()).bankCode(domainObj.getBankCode()).totalRecords(domainObj.getTotalRecords())
        .totalAmount(domainObj.getTotalAmount()).processedAt(domainObj.getProcessedAt())
        .errorMessage(domainObj.getErrorMessage()).fileContentSample(domainObj.getFileContentSample()).build();
  }

  public CnabFileControl toDomain(CnabFileControlEntity entity) {
    if (entity == null) {
      return null;
    }

    return CnabFileControl.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getFileName(),
        entity.getFileType(), entity.getStatus(), entity.getBankCode(), entity.getTotalRecords(),
        entity.getTotalAmount(), entity.getFileContentSample());
  }
}
