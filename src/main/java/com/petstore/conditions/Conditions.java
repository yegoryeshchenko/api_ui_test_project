package com.petstore.conditions;


import org.hamcrest.Matcher;

public class Conditions {

  public static StatusCodeCondition statusCode(int code) {
    return new StatusCodeCondition(code);
  }

  public static HeaderCondition header(String header, Matcher<String> stringMatcher) {
    return new HeaderCondition(header, stringMatcher);
  }

  public static BodyCondition body(String body, Matcher<String> stringMatcher) {
    return new BodyCondition(body, stringMatcher);
  }

  public static StatusLineCondition statusLine(String statusLine) {
    return new StatusLineCondition(statusLine);
  }

}
