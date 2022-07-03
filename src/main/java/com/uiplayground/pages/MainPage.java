package com.uiplayground.pages;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;

public class MainPage {

  private SelenideElement verifyTextLink = $("a[href='/verifytext']");
  private SelenideElement textInputLink = $(By.linkText("Text Input"));
  private SelenideElement loadDelayLink = $x("//a[@href='/loaddelay']");
  private SelenideElement loadingSpinner = $("#spinner");

  @Step("user opens main page")
  public static MainPage open() {
    return Selenide.open("/", MainPage.class);
  }

  @Step("user opens verifyText page")
  public VerifyTextPage openVerifyTextPage() {
    verifyTextLink.click();
    return new VerifyTextPage();
  }

  @Step("user opens text input page")
  public TextInputPage openTextInputPage() {
    textInputLink.click();
    return new TextInputPage();
  }

  @Step("user opens load delay page")
  public LoadDelayPage openLoadDelayPage() {
    loadDelayLink.click();
    loadingSpinner.shouldBe(disappear, Duration.ofSeconds(5));
    return new LoadDelayPage();
  }

}
