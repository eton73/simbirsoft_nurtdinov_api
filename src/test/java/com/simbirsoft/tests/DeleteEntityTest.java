package com.simbirsoft.tests;

import com.simbirsoft.EntityTestApplication;
import com.simbirsoft.helpers.Urls;
import com.simbirsoft.pogo.EntityRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class DeleteEntityTest extends EntityTestApplication {

  @Test
  public void deleteByIdTest() {
    EntityRequest request = createRequestFromFile();

    String createdId = createEntity(request);
    deleteEntityById(createdId);

    RestAssured.given(requestSpecification)
        .when()
        .get(Urls.API_GET_BY_ID_PATH, createdId)
        .then()
        .statusCode(500);
  }

}