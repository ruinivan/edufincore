package com.ruinivan.edufincore.infrastructure.gateway;

import org.springframework.stereotype.Component;

import com.ruinivan.edufincore.application.gateway.CourseGateway;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.mapper.CoursePersistenceMapper;
import com.ruinivan.edufincore.infrastructure.gateway.persistence.repository.CourseJpaRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class CourseRepositoryAdapter implements CourseGateway {

  private final CoursePersistenceMapper mapper;
  private final CourseJpaRepository repository;
}
