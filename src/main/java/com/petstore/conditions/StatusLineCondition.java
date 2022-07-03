package com.petstore.conditions;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StatusLineCondition implements Condition{

  private String statusLine;

  @Override
  public void check(ValidatableResponse response) {
    response.assertThat().statusLine(statusLine);
  }

  @Override
  public String toString() {
    return "status line is "+ statusLine;
  }

}
