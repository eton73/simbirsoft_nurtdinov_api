package com.simbirsoft.pogo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityResponse {

  private AdditionResponse addition;
  private Integer id;
  @JsonProperty("important_numbers")
  private Integer[] importantNumbers;
  private String title;
  private Boolean verified;

  public EntityResponse() {

  }

  public EntityResponse(AdditionResponse addition, Integer id, Integer[] importantNumbers,
      String title, Boolean verified) {
    this.addition = addition;
    this.id = id;
    this.importantNumbers = importantNumbers;
    this.title = title;
    this.verified = verified;
  }

  public AdditionResponse getAddition() {
    return addition;
  }

  public void setAddition(AdditionResponse addition) {
    this.addition = addition;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer[] getImportantNumbers() {
    return importantNumbers;
  }

  public void setImportantNumbers(Integer[] importantNumbers) {
    this.importantNumbers = importantNumbers;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getVerified() {
    return verified;
  }

  public void setVerified(Boolean verified) {
    this.verified = verified;
  }
}
