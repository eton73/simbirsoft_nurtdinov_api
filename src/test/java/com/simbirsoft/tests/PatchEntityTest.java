package com.simbirsoft.tests;

import com.simbirsoft.EntityTestApplication;
import com.simbirsoft.helpers.Urls;
import com.simbirsoft.pogo.EntityRequest;
import com.simbirsoft.pogo.EntityResponse;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class PatchEntityTest extends EntityTestApplication {

  @Test
  public void pathEntityTest() {
    EntityRequest request = createRequestFromFile();
    String createdId = createEntity(request);
    request.setTitle("another title");
    request.setImportantNumbers(new Integer[]{1,2,3});
    request.getAddition().setAdditionalInfo("another info");

    RestAssured.given(requestSpecification)
        .body(request)
        .when()
        .patch(Urls.API_PATCH_BY_ID_PATH, createdId)
        .then()
        .statusCode(204)
        .extract();

    EntityResponse response = RestAssured.given(requestSpecification)
        .when()
        .get(Urls.API_GET_BY_ID_PATH, createdId)
        .then()
        .statusCode(200)
        .extract().as(EntityResponse.class);

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(response).isNotNull();
    softAssertions.assertThat(response.getImportantNumbers()).isEqualTo(request.getImportantNumbers());
    softAssertions.assertThat(response.getTitle()).isEqualTo(request.getTitle());
    softAssertions.assertThat(response.getVerified()).isEqualTo(request.getVerified());
    softAssertions.assertThat(response.getAddition()).isNotNull();
    softAssertions.assertThat(response.getAddition().getAdditionalInfo())
        .isEqualTo(request.getAddition().getAdditionalInfo());
    softAssertions.assertThat(response.getAddition().getAdditionalNumber())
        .isEqualTo(request.getAddition().getAdditionalNumber());
    softAssertions.assertAll();

    deleteEntityById(createdId);
  }
}
