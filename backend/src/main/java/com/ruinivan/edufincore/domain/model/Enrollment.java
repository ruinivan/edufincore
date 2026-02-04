package com.ruinivan.edufincore.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Enrollment extends Base {
  private UUID studentId;
  private UUID courseId;
  private LocalDate enrollmentDate;
  private EnrollmentStatus status;

  public Enrollment(UUID studentId, UUID courseId, LocalDate enrollmentDate) {
    super();
    this.studentId = studentId;
    this.courseId = courseId;
    this.enrollmentDate = enrollmentDate;
    this.status = EnrollmentStatus.ACTIVE;
  }

  public Enrollment(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID studentId, UUID courseId,
      LocalDate enrollmentDate, EnrollmentStatus status) {
    super(id, createdAt, updatedAt);
    this.studentId = studentId;
    this.courseId = courseId;
    this.enrollmentDate = enrollmentDate;
    this.status = status;
  }

  public UUID getStudentId() {
    return this.studentId;
  }

  public UUID getCourseId() {
    return this.courseId;
  }

  public LocalDate getEnrollmentDate() {
    return this.enrollmentDate;
  }

  public EnrollmentStatus getStatus() {
    return this.status;
  }
}
