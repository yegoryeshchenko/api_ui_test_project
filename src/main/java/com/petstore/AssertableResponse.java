package com.petstore;

import com.petstore.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AssertableResponse {

  private final ValidatableResponse response;

  @Step("api response should have {condition}")
  public AssertableResponse shouldHave(Condition condition) {
    log.info("checking for " + condition);
    condition.check(response);
    return this;
  }

  public <T> Object getFieldValueBy(String jsonPath) {
    return response.extract().jsonPath().get(jsonPath);
  }

  public <T> T asPojo(Class<T> tClass) {
    return response.extract().body().as(tClass);
  }
}
