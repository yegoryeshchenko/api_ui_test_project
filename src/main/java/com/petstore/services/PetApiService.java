package com.petstore.services;

import com.petstore.Endpoints;
import com.petstore.AssertableResponse;
import com.petstore.models.Pet;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PetApiService extends AbstractService {

  @Step("create tet {0}")
  public AssertableResponse createPet(Pet pet) {
    log.info("create {} pet", pet);
    return new AssertableResponse(setUp()
        .body(pet)
        .post(Endpoints.PET)
        .then());
  }

  @Step("get pet {0}")
  public AssertableResponse getPet(long petId) {
    log.info("get pet by id {}", petId);
    return new AssertableResponse(setUp()
        .get(Endpoints.PET_BY_ID, petId)
        .then());
  }

}
