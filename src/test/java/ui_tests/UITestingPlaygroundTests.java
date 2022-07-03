package ui_tests;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

import com.uiplayground.pages.MainPage;
import org.junit.jupiter.api.Test;

public class UITestingPlaygroundTests extends BaseUITest {

  @Test
  void testVerifyTextPage() {
    MainPage.open()
        .openVerifyTextPage()
        .welcomeText.shouldHave(exactText("Welcome UserName!"));
  }

  @Test
  void testVerifyTextInputPage() {
    String buttonName = faker.rockBand().name();
    MainPage.open()
        .openTextInputPage()
        .setNewButtonName(buttonName)
        .updatingButton
        .shouldHave(exactText(buttonName));
  }

  @Test
  void testVerifyLoadDelayPage() {
    MainPage.open()
        .openLoadDelayPage()
        .buttonAfterDelay
        .shouldBe(visible);
  }

}
