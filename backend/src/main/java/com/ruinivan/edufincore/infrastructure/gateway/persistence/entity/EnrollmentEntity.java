package com.ruinivan.edufincore.infrastructure.gateway.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ENROLLMENT", indexes = {
    @Index(name = "IDX_ENROLL_STUDENT", columnList = "student_id"),
    @Index(name = "IDX_ENROLL_STATUS", columnList = "status")
})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class EnrollmentEntity extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "student_id", nullable = false)
  private StudentEntity student;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "course_id", nullable = false)
  private CourseEntity course;

  @Column(name = "enrollment_date", nullable = false)
  private LocalDate enrollmentDate;

  @Column(nullable = false, length = 20)
  private String status; // ACTIVE, LOCKED, GRADUATED, DROPPED

  // Lista de mensalidades geradas para esta matrícula
  @Builder.Default
  @OneToMany(mappedBy = "enrollment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<TuitionEntity> tuitions = new ArrayList<>();
}