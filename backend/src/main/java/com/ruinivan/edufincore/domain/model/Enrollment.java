package com.ruinivan.edufincore.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Enrollment extends Base {
  private UUID studentId;
  private UUID courseId;
  private LocalDate enrollmentDate;
  private EnrollmentStatus status;

  public Enrollment(UUID studentId, UUID courseId, LocalDate enrollmentDate) {
    this.studentId = studentId;
    this.courseId = courseId;
    this.enrollmentDate = enrollmentDate;
    this.status = EnrollmentStatus.ACTIVE;
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
