package com.simbirsoft.tests;

import com.simbirsoft.EntityTestApplication;
import com.simbirsoft.helpers.Urls;
import com.simbirsoft.pogo.EntityBaseResponse;
import com.simbirsoft.pogo.EntityRequest;
import com.simbirsoft.pogo.EntityResponse;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class GetAllEntityTest extends EntityTestApplication {

  private static final String TITLE_PARAM = "title";
  private static final String VERIFIED_PARAM = "verified";

  @Test
  public void getAllTest() {
    EntityRequest request = createRequestFromFile();
    String firstCreatedId = createEntity(request);
    String secondCreatedId = createEntity(request);

    EntityBaseResponse response = RestAssured.given(requestSpecification)
        .when()
        .get(Urls.API_GET_ALL_PATH)
        .then()
        .statusCode(200)
        .extract().as(EntityBaseResponse.class);

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(response).isNotNull();
    softAssertions.assertThat(response.getEntity()).isNotNull();
    int responseSize = response.getEntity().length;
    softAssertions.assertThat(response.getEntity()[responseSize - 2].getId()).isEqualTo(firstCreatedId);
    softAssertions.assertThat(response.getEntity()[responseSize - 1].getId()).isEqualTo(secondCreatedId);

    deleteEntityById(firstCreatedId);
    deleteEntityById(secondCreatedId);
  }

  @Test
  public void getAllByTitleAndVerifiedTest() {
    String expectedTitle = "another title";
    Boolean expectedVerified = false;
    EntityRequest request = createRequestFromFile();
    request.setTitle(expectedTitle);
    request.setVerified(expectedVerified);
    String firstCreatedId = createEntity(request);

    EntityBaseResponse response = RestAssured.given(requestSpecification)
        .when()
        .params(TITLE_PARAM, expectedTitle, VERIFIED_PARAM, expectedVerified)
        .get(Urls.API_GET_ALL_PATH)
        .then()
        .statusCode(200)
        .extract().as(EntityBaseResponse.class);

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(response).isNotNull();
    softAssertions.assertThat(response.getEntity()).isNotNull();

    for (EntityResponse entity : response.getEntity()) {
      softAssertions.assertThat(entity.getTitle()).isEqualTo(request.getTitle());
      softAssertions.assertThat(entity.getVerified()).isEqualTo(request.getVerified());
    }

    deleteEntityById(firstCreatedId);
  }

}
