package com.simbirsoft.pogo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdditionRequest {

  @JsonProperty("additional_info")
  private String additionalInfo;
  @JsonProperty("additional_number")
  private Integer additionalNumber;

  public AdditionRequest() {
  }

  public AdditionRequest(String additionalInfo, Integer additionalNumber) {
    this.additionalInfo = additionalInfo;
    this.additionalNumber = additionalNumber;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public Integer getAdditionalNumber() {
    return additionalNumber;
  }

  public void setAdditionalNumber(Integer additionalNumber) {
    this.additionalNumber = additionalNumber;
  }
}
