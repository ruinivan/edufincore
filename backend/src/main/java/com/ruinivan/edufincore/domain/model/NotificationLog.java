package com.ruinivan.edufincore.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationLog extends Base {
  private String recipient;
  private String subject;
  private String channel;
  private NotificationLogStatus status;
  private String errorMessage;
  private UUID studentId;

  public NotificationLog(String recipient, String subject, String channel, String errorMessage, UUID studentId) {
    super();
    this.recipient = recipient;
    this.subject = subject;
    this.channel = channel;
    this.errorMessage = errorMessage;
    this.studentId = studentId;
    this.status = NotificationLogStatus.PENDING;
  }

  public static NotificationLog restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String recipient,
      String subject, String channel, NotificationLogStatus status, String errorMessage, UUID studentId) {
    return new NotificationLog(id, createdAt, updatedAt, recipient, subject, channel, status, errorMessage, studentId);
  }

  private NotificationLog(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, String recipient, String subject,
      String channel, NotificationLogStatus status, String errorMessage, UUID studentId) {
    super(id, createdAt, updatedAt);
    this.recipient = recipient;
    this.subject = subject;
    this.channel = channel;
    this.status = status;
    this.errorMessage = errorMessage;
    this.studentId = studentId;
  }

  public String getRecipient() {
    return this.recipient;
  }

  public String getSubject() {
    return this.subject;
  }

  public String getChannel() {
    return this.channel;
  }

  public NotificationLogStatus getStatus() {
    return this.status;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }

  public UUID getStudentId() {
    return this.studentId;
  }
}
