package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Base {
  private UUID id;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

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
