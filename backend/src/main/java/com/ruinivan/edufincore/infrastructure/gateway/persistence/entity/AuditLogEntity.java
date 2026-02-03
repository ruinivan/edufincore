package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_AUDIT_LEDGER")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "entity_id", nullable = false)
    private UUID entityId;

    @Column(name = "entity_type", nullable = false)
    private String entityType;

    @Column(nullable = false)
    private String operation;

    @Column(name = "old_value", length = 4000)
    private String oldValue;

    @Column(name = "new_value", length = 4000)
    private String newValue;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "user_system")
    private String userSystem;

    @PrePersist
    public void prePersist() {
        if (this.timestamp == null) {
            this.timestamp = LocalDateTime.now();
        }
    }

    public AuditLogEntity(UUID entityId, String entityType, String operation,
            String oldValue, String newValue, String userSystem) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.operation = operation;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.userSystem = userSystem;
    }
}