package com.ruinivan.edufincore.application.usecase;

import com.ruinivan.edufincore.application.gateway.AuditLogGateway;
import com.ruinivan.edufincore.domain.model.AuditLog;

public class CreateAuditLogImpl implements CreateAuditLog {

  private final AuditLogGateway gateway;

  public CreateAuditLogImpl(AuditLogGateway gateway) {
    this.gateway = gateway;
  }

  @Override
  public AuditLog execute(AuditLog input) {
    return gateway.save(input);
  }

}
