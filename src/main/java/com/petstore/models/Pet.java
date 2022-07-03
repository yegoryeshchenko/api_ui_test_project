package com.petstore.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Pet {

  private String id;
  private Item category;
  private String name;
  private String status;
  private List<String> photoUrls;
  private List<Item> items;

  @Data
  @Builder
  public static class Item {
    int id;
    String name;
  }

}
