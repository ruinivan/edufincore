package com.ruinivan.edufincore.domain.model;

import java.util.UUID;

public class NotificationLog extends Base {
  private String recipient;
  private String subject;
  private String channel;
  private NotificationLogStatus status;
  private String errorMessage;
  private UUID studentId;

  public NotificationLog(String recipient, String subject, String channel, String errorMessage, UUID studentId) {
    this.recipient = recipient;
    this.subject = subject;
    this.channel = channel;
    this.errorMessage = errorMessage;
    this.studentId = studentId;
    this.status = NotificationLogStatus.PENDING;
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
