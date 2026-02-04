package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuditLog {
  private UUID id;
  private UUID entityId;
  private String entityType;
  private String operation;
  private String oldValue;
  private String newValue;
  private LocalDateTime timestamp;
  private String userSystem;

  public AuditLog(UUID entityId, String entityType, String operation, String oldValue, String newValue,
      String userSystem) {
    this.entityId = entityId;
    this.entityType = entityType;
    this.operation = operation;
    this.oldValue = oldValue;
    this.newValue = newValue;
    this.userSystem = userSystem;
    this.id = null;
    this.timestamp = null;
  }

  public static AuditLog restore(UUID id, UUID entityId, String entityType, String operation, String oldValue,
      String newValue, LocalDateTime timestamp, String userSystem) {
    return new AuditLog(id, entityId, entityType, operation, oldValue, newValue, timestamp, userSystem);
  }

  private AuditLog(UUID id, UUID entityId, String entityType, String operation, String oldValue, String newValue,
      LocalDateTime timestamp, String userSystem) {
    this.id = id;
    this.entityId = entityId;
    this.entityType = entityType;
    this.operation = operation;
    this.oldValue = oldValue;
    this.newValue = newValue;
    this.timestamp = timestamp;
    this.userSystem = userSystem;
  }

  public UUID getId() {
    return this.id;
  }

  public UUID getEntityId() {
    return this.entityId;
  }

  public String getEntityType() {
    return this.entityType;
  }

  public String getOperation() {
    return this.operation;
  }

  public String getOldValue() {
    return this.oldValue;
  }

  public String getNewValue() {
    return this.newValue;
  }

  public LocalDateTime getTimestamp() {
    return this.timestamp;
  }

  public String getUserSystem() {
    return this.userSystem;
  }
}
