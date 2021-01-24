package com.mobymax.automation.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UserHomePage {
    private final SelenideElement registerStudentBtn = $(byText("Register Your Students"));

    @Step("Verify register button is visible")
    public UserHomePage verifyRegisterStudentButtonVisible() {
        registerStudentBtn.should(visible);
        return this;
    }
}
