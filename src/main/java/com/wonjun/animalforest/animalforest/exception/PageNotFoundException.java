package com.wonjun.animalforest.animalforest.exception;

public class PageNotFoundException extends RuntimeException{
  public PageNotFoundException() { super("페이지가 존재하지 않습니다.");}
  public PageNotFoundException(String message) {super(message);}
}
