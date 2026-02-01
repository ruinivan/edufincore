package com.ruinivan.edufincore.application.usecase;

import com.ruinivan.edufincore.domain.model.Student;

public interface CreateStudent {
  Student execute(Student input);
}
