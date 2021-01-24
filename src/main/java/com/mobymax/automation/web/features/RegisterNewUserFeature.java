package com.mobymax.automation.web.features;

import com.mobymax.automation.models.UserModel;
import com.mobymax.automation.web.pages.LandingPage;
import com.mobymax.automation.web.pages.UserHomePage;
import io.qameta.allure.Step;

public class RegisterNewUserFeature {
    private final UserModel user;
    private final LandingPage landingPage;
    private final UserHomePage userHomePage;

    public RegisterNewUserFeature(UserModel user) {
        this.user = user;
        landingPage = new LandingPage();
        userHomePage = new UserHomePage();
    }

    @Step("Register new user")
    public void register() {
        selectRegistrationType();
        selectJobPosition();
        setFirstName();
        setLastName();
        selectState();
        selectSchool();
        setEmailAddress();
        setPassword();
        clickOnRegister();
        verifyUserCreated();
    }

    private void verifyUserCreated() {
        userHomePage.verifyRegisterStudentButtonVisible();
    }

    private void clickOnRegister() {
        landingPage.clickOnRegister();
    }

    private void setPassword() {
        landingPage.setPassword(user.getPassword());
    }

    private void setEmailAddress() {
        landingPage.setEmail(user.getEmail());
    }

    private void selectSchool() {
        landingPage.selectSchool(user.getSchool());
    }

    private void selectState() {
        landingPage.selectState(user.getSchool().getState());
    }

    private void setLastName() {
        landingPage.setLastName(user.getLastName());
    }

    private void setFirstName() {
        landingPage.setFirstName(user.getFirstName());
    }

    private void selectJobPosition() {
        landingPage.selectJobPosition(user.getJobPosition());
    }

    private void selectRegistrationType() {
        landingPage.selectRegistrationType(user.getRegistrationType());
    }
}
