package com.petstore.test_data_providers;

import com.github.javafaker.Faker;
import com.petstore.models.User;

public class UserDataProvider {

  private final Faker faker = new Faker();

  public User getUserWithAllValidFields() {
    return User.builder()
        .id(0)
        .username(faker.name().username())
        .firstName(faker.name().firstName())
        .lastName(faker.name().lastName())
        .email(faker.internet().emailAddress())
        .password(faker.internet().password())
        .phone(faker.phoneNumber().cellPhone())
        .userStatus(0)
        .build();
  }

}
