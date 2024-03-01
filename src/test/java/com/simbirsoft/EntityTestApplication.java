package com.simbirsoft;

import com.simbirsoft.helpers.ObjectMapperHelper;
import com.simbirsoft.helpers.Urls;
import com.simbirsoft.pogo.EntityRequest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class EntityTestApplication {

  protected static RequestSpecification requestSpecification;

  @BeforeAll
  static void setUp() {
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    requestSpecBuilder = requestSpecBuilder
        .setContentType(ContentType.JSON)
        .setBaseUri(ConfProperties.getProperty("base-url"));
    requestSpecification = requestSpecBuilder.build();
  }

  protected EntityRequest createRequestFromFile() {
    return (EntityRequest)
        ObjectMapperHelper.readValue("src/test/resources/entity_request.json", EntityRequest.class);
  }

  protected String createEntity(Object body) {
    return RestAssured.given(requestSpecification)
        .body(body)
        .when()
        .post(Urls.API_CREATE_PATH)
        .then()
        .statusCode(200)
        .extract().response().body().print();
  }

  protected void deleteEntityById(String id) {
    RestAssured.given(requestSpecification)
        .when()
        .delete(Urls.API_DELETE_BY_ID_PATH, id)
        .then()
        .statusCode(204)
        .extract();
  }

}
