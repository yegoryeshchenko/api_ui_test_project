package com.petstore.services;

import com.petstore.AssertableResponse;
import com.petstore.Endpoints;
import com.petstore.models.User;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserApiService extends AbstractService {

  @Step("create new user {0}")
  public AssertableResponse createUser(User user) {
    log.info("create user {}", user);
    return new AssertableResponse(setUp()
        .body(user)
        .when()
        .post(Endpoints.USER)
        .then());
  }

  @Step("get user by {0} name")
  public AssertableResponse getUserByName(String userName) {
    log.info("retrieving user with name {}", userName);
    return new AssertableResponse(
        setUp()
            .when()
            .get(Endpoints.GET_USER_BY_NAME, userName)
            .then());
  }

  @Step("login as {0} user")
  public AssertableResponse login(User user) {
    String userName = user.getUsername();
    String password = user.getPassword();
    log.info("login with next credentials: {}/{}", userName, password);
    return new AssertableResponse(
        setUp()
            .when()
            .queryParam("username", userName)
            .queryParam("password", password)
            .get(Endpoints.USER_LOGIN)
            .then());
  }

  @Step("delete user with '{0}' name")
  public AssertableResponse deleteUserByName(String userName) {
    log.info("delete user wit name {}", userName);
    return new AssertableResponse(
        setUp()
            .when()
            .delete(Endpoints.GET_USER_BY_NAME, userName)
            .then());
  }

}
