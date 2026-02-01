package com.ruinivan.edufincore.domain.exception;

public class StudentAlreadyExistsException extends RuntimeException {
  public StudentAlreadyExistsException(String message) {
    super(message);
  }
}