package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_NOTIFICATION_LOG")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class NotificationLogEntity extends BaseEntity {

  @Column(nullable = false)
  private String recipient; // email@aluno.com

  @Column(nullable = false)
  private String subject;

  @Column(nullable = false, length = 20)
  private String channel; // EMAIL, SMS, WHATSAPP

  @Column(nullable = false, length = 20)
  private String status; // SENT, FAILED, PENDING

  @Column(name = "error_message", length = 4000)
  private String errorMessage;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id")
  private StudentEntity student;
}