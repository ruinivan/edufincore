package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import com.ruinivan.edufincore.domain.model.NotificationLogStatus;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "TB_NOTIFICATION_LOG")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SuperBuilder
public class NotificationLogEntity extends BaseEntity {

  @Column(nullable = false)
  private String recipient; // email@aluno.com

  @Column(nullable = false)
  private String subject;

  @Column(nullable = false, length = 20)
  private String channel; // EMAIL, SMS, WHATSAPP

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private NotificationLogStatus status; // SENT, FAILED, PENDING

  @Column(name = "error_message", length = 4000)
  private String errorMessage;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id")
  private StudentEntity student;
}