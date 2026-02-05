package com.ruinivan.edufincore.application.usecase;

import com.ruinivan.edufincore.domain.model.AuditLog;

public interface CreateAuditLog {
  AuditLog execute(AuditLog input);
}
