package com.ruinivan.edufincore.application.gateway;

import com.ruinivan.edufincore.domain.model.AuditLog;

public interface AuditLogGateway {
  AuditLog save(AuditLog log);
}
