package com.mobymax.automation.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.mobymax.automation.input.data.UserType;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SignInPage {
    private final SelenideElement usernameInput = $("#UserUsername"),
            passwordInput = $("#UserPassword"),
            signInBtn = $("#signin-btn");
    private final ElementsCollection headerMenuItems = $$(".header-menu .header-menu-item");

    @Step("Sign in")
    public UserHomePage signIn() {
        signInBtn.click();
        return new UserHomePage();
    }

    @Step("Set username")
    public SignInPage setUsername(String username) {
        usernameInput.setValue(username);
        return this;
    }

    @Step("Set password")
    public SignInPage setPassword(String pass) {
        passwordInput.setValue(pass);
        return this;
    }

    @Step("Select user type")
    public SignInPage selectType(UserType type) {
        switch (type) {
            case TEACHER: {
                headerMenuItems.find(exactText("As a Teacher")).click();
                break;
            }
            default:
                throw new RuntimeException("Provide implementation for '" + type + "' user type");
        }
        return this;
    }
}
