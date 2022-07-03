package com.petstore.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

@AllArgsConstructor
public class BodyCondition implements Condition {

  private String bodyParam;
  private Matcher<String> bodyMatcher;

  @Override
  public void check(ValidatableResponse response) {
    response.assertThat().body(bodyParam, bodyMatcher);
  }

  @Override
  public String toString() {
    return "body " + bodyParam +
        "match " + bodyMatcher;
  }
}
