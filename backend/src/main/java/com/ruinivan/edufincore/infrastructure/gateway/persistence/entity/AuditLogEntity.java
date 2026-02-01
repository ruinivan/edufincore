package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_AUDIT_LEDGER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "entity_id", nullable = false)
    private String entityId; // ID da Tuition ou Student

    @Column(name = "entity_type", nullable = false)
    private String entityType; // "TUITION", "STUDENT"

    @Column(nullable = false)
    private String operation; // "CREATE", "UPDATE_STATUS", "APPLY_PENALTY"

    @Column(name = "old_value", length = 4000) // Oracle suporta VARCHAR2 4000
    private String oldValue;

    @Column(name = "new_value", length = 4000)
    private String newValue;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "user_system")
    private String userSystem; // "SYSTEM_CNAB_PROCESSOR" ou ID do usuario
}