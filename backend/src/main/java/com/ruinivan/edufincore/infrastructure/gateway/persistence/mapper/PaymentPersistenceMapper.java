package com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper;

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

    var entityBuilder = PaymentEntity.builder().id(domainObj.getId()).amountPaid(domainObj.getAmountPaid())
        .paymentMethod(domainObj.getPaymentMethod()).bankTransactionId(domainObj.getBankTransactionId())
        .occurredAt(domainObj.getOccurredAt());

    TuitionEntity tuitionRef = TuitionEntity.builder().id(domainObj.getTuitionId()).build();

    return entityBuilder.tuition(tuitionRef).build();
  }

  public Payment toDomain(PaymentEntity entity) {
    if (entity == null) {
      return null;
    }

    return Payment.restore(entity.getId(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getTuition().getId(),
        entity.getAmountPaid(), entity.getPaymentMethod(), entity.getBankTransactionId(), entity.getOccurredAt());
  }
}
