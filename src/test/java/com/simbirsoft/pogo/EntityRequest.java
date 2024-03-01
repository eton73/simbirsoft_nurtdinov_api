package com.simbirsoft.pogo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityRequest {

  private AdditionRequest addition;
  @JsonProperty("important_numbers")
  private Integer[] importantNumbers;
  private String title;
  private Boolean verified;

  public EntityRequest() {

  }

  public EntityRequest(AdditionRequest addition, Integer[] importantNumbers, String title,
      Boolean verified) {
    this.addition = addition;
    this.importantNumbers = importantNumbers;
    this.title = title;
    this.verified = verified;
  }

  public AdditionRequest getAddition() {
    return addition;
  }

  public void setAddition(AdditionRequest addition) {
    this.addition = addition;
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
