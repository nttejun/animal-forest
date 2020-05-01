package com.wonjun.animalforest.animalforest.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(){
    this("Resource Not Found");
  }
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
