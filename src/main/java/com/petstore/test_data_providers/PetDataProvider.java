package com.petstore.test_data_providers;

import com.github.javafaker.Faker;
import com.petstore.models.Pet;
import com.petstore.models.Pet.Item;
import java.util.ArrayList;
import java.util.List;

public class PetDataProvider {

  private final Faker faker = new Faker();

  private Item category = Item.builder().id(0).name(faker.animal().name()).build();
  private Item item = Item.builder().id(0).name(faker.lorem().fixedString(7)).build();
  private List<Item> items = new ArrayList<>();

  public Pet getPetWithAllValidFields() {
    items.add(item);
    return Pet.builder()
        .name(faker.animal().name())
        .status("available")
        .items(items)
        .photoUrls(new ArrayList<>())
        .category(category)
        .build();
  }

}
