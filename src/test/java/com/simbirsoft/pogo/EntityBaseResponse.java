package com.simbirsoft.pogo;

public class EntityBaseResponse {

  private EntityResponse[] entity;

  public EntityBaseResponse() {
  }

  public EntityBaseResponse(EntityResponse[] entity) {
    this.entity = entity;
  }

  public EntityResponse[] getEntity() {
    return entity;
  }

  public void setEntity(EntityResponse[] entity) {
    this.entity = entity;
  }
}
