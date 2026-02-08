package com.ruinivan.edufincore.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Enrollment extends Base {
  private UUID studentId;
  private UUID courseId;
  private LocalDate enrollmentDate;
  private EnrollmentStatus status;
  private List<Tuition> tuitions;

  public Enrollment(UUID studentId, UUID courseId, LocalDate enrollmentDate) {
    super();
    this.studentId = studentId;
    this.courseId = courseId;
    this.enrollmentDate = enrollmentDate;
    this.status = EnrollmentStatus.ACTIVE;
    this.tuitions = new ArrayList<>();
  }

  public static Enrollment restore(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID studentId,
      UUID courseId,
      LocalDate enrollmentDate, EnrollmentStatus status, List<Tuition> tuitions) {
    return new Enrollment(id, createdAt, updatedAt, studentId, courseId, enrollmentDate, status, tuitions);
  }

  private Enrollment(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, UUID studentId, UUID courseId,
      LocalDate enrollmentDate, EnrollmentStatus status, List<Tuition> tuitions) {
    super(id, createdAt, updatedAt);
    this.studentId = studentId;
    this.courseId = courseId;
    this.enrollmentDate = enrollmentDate;
    this.status = status;
    this.tuitions = tuitions;
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

  public List<Tuition> getTuitions() {
    return this.tuitions;
  }
}
