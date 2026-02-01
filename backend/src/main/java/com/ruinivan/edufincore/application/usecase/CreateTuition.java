package com.ruinivan.edufincore.application.usecase;

import com.ruinivan.edufincore.application.dto.CreateTuitionDTO;
import com.ruinivan.edufincore.domain.model.Tuition;

public interface CreateTuition {
  Tuition execute(CreateTuitionDTO input);
}
