package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Base {
  protected UUID id;
  protected LocalDateTime createdAt;
  protected LocalDateTime updatedAt;

  public Base() {
    this.id = null;
    this.createdAt = null;
    this.updatedAt = null;
  }

  protected Base(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public UUID getId() {
    return this.id;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }
}
