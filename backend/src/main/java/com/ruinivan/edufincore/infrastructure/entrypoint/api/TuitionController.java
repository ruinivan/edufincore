package com.ruinivan.edufincore.infrastructure.entrypoint.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruinivan.edufincore.application.dto.CreateTuitionDTO;
import com.ruinivan.edufincore.application.usecase.CreateTuition;
import com.ruinivan.edufincore.domain.model.Tuition;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/tuitions")
@RequiredArgsConstructor
public class TuitionController {
    private final CreateTuition createTuitionUseCase;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid CreateTuitionDTO dto) {
        Tuition createdTuition = createTuitionUseCase.execute(dto);

        return ResponseEntity.created(URI.create("/api/v1/tuitions/" + createdTuition.getId())).body(createdTuition);
    }

}
