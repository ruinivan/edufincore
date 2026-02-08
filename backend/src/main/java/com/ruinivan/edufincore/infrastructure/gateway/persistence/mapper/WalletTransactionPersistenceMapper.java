package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.WalletTransaction;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.PaymentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.StudentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.WalletTransactionEntity;

@Component
public class WalletTransactionPersistenceMapper {

  public WalletTransactionEntity toEntity(WalletTransaction domainObj) {
    if (domainObj == null) {
      return null;
    }

    StudentEntity studentRef = StudentEntity.builder().id(domainObj.getStudentId()).build();

    PaymentEntity originPaymentRef = PaymentEntity.builder().id(domainObj.getOriginPayment()).build();

    return WalletTransactionEntity.builder().id(domainObj.getId()).createdAt(domainObj.getCreatedAt())
        .updatedAt(domainObj.getUpdatedAt()).amount(domainObj.getAmount()).balanceAfter(domainObj.getBalanceAfter())
        .description(domainObj.getDescription()).student(studentRef).originPayment(originPaymentRef).build();
  }
}
