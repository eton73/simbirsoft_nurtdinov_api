package com.simbirsoft.pogo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdditionResponse {

  @JsonProperty("additional_info")
  private String additionalInfo;
  @JsonProperty("additional_number")
  private Integer additionalNumber;
  private Integer id;

  public AdditionResponse() {

  }

  public AdditionResponse(String additionalInfo, Integer additionalNumber, Integer id) {
    this.additionalInfo = additionalInfo;
    this.additionalNumber = additionalNumber;
    this.id = id;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
