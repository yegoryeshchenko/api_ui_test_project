package api_tests;

import static com.petstore.conditions.Conditions.body;
import static com.petstore.conditions.Conditions.statusCode;
import static org.hamcrest.CoreMatchers.equalTo;

import com.petstore.AssertableResponse;
import com.petstore.models.Pet;
import com.petstore.models.User;
import com.petstore.services.PetApiService;
import com.petstore.services.UserApiService;
import com.petstore.test_data_providers.TestData;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PetstoreTests {

  private UserApiService userApiService = new UserApiService();
  private PetApiService petApiService = new PetApiService();
  private User user;
  private Pet pet;

  @BeforeAll
  static void setUp() {
    RestAssured.baseURI = "https://petstore.swagger.io/v2";
  }

  @Test
  public void testCanRegisterAmdLoginAsValidUser() {
    user = TestData.getPetUserProvider().getUserWithAllValidFields();
    userApiService.createUser(user).shouldHave(statusCode(200));
    userApiService.getUserByName(user.getUsername())
        .shouldHave(statusCode(200))
        .shouldHave(body("username", equalTo(user.getUsername())))
        .shouldHave(body("firstName", equalTo(user.getFirstName())));

    userApiService.createUser(user).shouldHave(statusCode(200));
    userApiService.login(user).shouldHave(statusCode(200));
  }

  @Test
  public void testCanDeleteUserByName() {
    user = TestData.getPetUserProvider().getUserWithAllValidFields();
    userApiService.createUser(user);
    userApiService.deleteUserByName(user.getUsername())
        .shouldHave(statusCode(200));

    userApiService.getUserByName(user.getUsername())
        .shouldHave(statusCode(404))
        .shouldHave(body("type", equalTo("error")))
        .shouldHave(body("message", equalTo("User not found")));
  }

  @Test
  public void testCanCreateNewPet() {
    pet = TestData.getPetDataProvider().getPetWithAllValidFields();
    AssertableResponse response = petApiService.createPet(pet)
        .shouldHave(statusCode(200))
        .shouldHave(body("name", equalTo(pet.getName())))
        .shouldHave(body("category.name", equalTo(pet.getCategory().getName())));
    long id = (long) response.getFieldValueBy("id");

    petApiService.getPet(id)
        .shouldHave(statusCode(200))
        .shouldHave(body("name", equalTo(pet.getName())))
        .shouldHave(body("category.name", equalTo(pet.getCategory().getName())));
  }

}
