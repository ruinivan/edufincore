package com.ruinivan.edufincore.infrastructure.entrypoint.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruinivan.edufincore.application.usecase.CreateStudent;
import com.ruinivan.edufincore.domain.model.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
  private final CreateStudent createStudentUseCse;

  @PostMapping
  public Student postMethodName(@RequestBody Student student) {

    return createStudentUseCse.execute(student);
  }

}
