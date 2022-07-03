package com.petstore.conditions;

import static org.hamcrest.Matchers.is;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

@AllArgsConstructor
public class HeaderCondition implements Condition{
  private String headerName;
  private Matcher<String> headerValueMatcher;

  @Override
  public void check(ValidatableResponse response) {
    response.assertThat().header(headerName, is(headerValueMatcher));
  }

  @Override
  public String toString() {
    return "header " + headerName +
        "is " + headerValueMatcher;
  }

}
