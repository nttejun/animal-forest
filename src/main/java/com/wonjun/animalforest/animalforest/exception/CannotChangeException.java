package com.wonjun.animalforest.animalforest.exception;

public class CannotChangeException extends RuntimeException {
  public CannotChangeException() { super(); }
  public CannotChangeException(String message) { super(message); }
}
