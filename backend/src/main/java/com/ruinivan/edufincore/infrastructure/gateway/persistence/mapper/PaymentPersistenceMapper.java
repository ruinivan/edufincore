package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.domain.model.Payment;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.PaymentEntity;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.entity.TuitionEntity;

@Component
public class PaymentPersistenceMapper {

  public PaymentEntity toEntity(Payment domainObj) {
    if (domainObj == null) {
      return null;
    }

    TuitionEntity tuitionRef = TuitionEntity.builder().id(domainObj.getTuitionId()).build();

    return PaymentEntity.builder().id(domainObj.getId()).amountPaid(domainObj.getAmountPaid())
        .paymentMethod(domainObj.getPaymentMethod()).bankTransactionId(domainObj.getBankTransactionId())
        .occurredAt(domainObj.getOccurredAt()).tuition(tuitionRef).build();
  }

  public Payment toDomain(PaymentEntity entity) {
    if (entity == null) {
      return null;
    }

    UUID tuitionId = entity.getTuition() == null ? null : entity.getTuition().getId();

    return Payment.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), tuitionId,
        entity.getAmountPaid(), entity.getPaymentMethod(), entity.getBankTransactionId(), entity.getOccurredAt());
  }
}
