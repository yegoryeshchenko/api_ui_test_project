package com.petstore.test_data_providers;

public class TestData {

  public static UserDataProvider getPetUserProvider() {
    return new UserDataProvider();
  }

  public static PetDataProvider getPetDataProvider() {
    return new PetDataProvider();
  }

}
