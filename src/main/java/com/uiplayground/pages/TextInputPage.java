package com.uiplayground.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TextInputPage {

  private SelenideElement myButtonInput = $(By.xpath("//input[@class='form-control']"));
  public SelenideElement updatingButton = $("#updatingButton");

  @Step("user sets new button name {0]")
  public TextInputPage setNewButtonName(String name) {
    myButtonInput.setValue(name);
    updatingButton.click();
    return this;
  }

}
