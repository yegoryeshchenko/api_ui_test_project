package com.uiplayground.pages;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class LoadDelayPage {

  public SelenideElement buttonAfterDelay = $x("//button[@class='btn btn-primary']");
}
