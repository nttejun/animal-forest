package com.wonjun.animalforest.animalforest.exception;

public class PageNotFoundException extends RuntimeException {

  public PageNotFoundException(){
    super("해당 페이지는 존재하지 않습니다.");
  }

}
