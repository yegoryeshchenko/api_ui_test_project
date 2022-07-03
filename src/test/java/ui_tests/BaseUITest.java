package ui_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseUITest {

  protected Faker faker = new Faker();

  @BeforeAll
  public static void setUp() {
    Configuration.browser = "chrome";
    Configuration.browserSize = "1080x768";
    Configuration.baseUrl = "http://uitestingplayground.com";
  }

  @AfterAll
  public static void tearDown() {
    Selenide.closeWebDriver();
  }

}
