package com.mobymax.automation.web.features;

import com.mobymax.automation.models.UserModel;
import com.mobymax.automation.web.pages.LandingPage;
import com.mobymax.automation.web.pages.SignInPage;
import com.mobymax.automation.web.pages.UserHomePage;
import io.qameta.allure.Step;

public class LoginFeature {
    private final UserModel user;
    private final LandingPage landingPage;
    private final SignInPage signInPage;
    private final UserHomePage userHomePage;

    public LoginFeature(UserModel user) {
        this.user = user;
        landingPage = new LandingPage();
        signInPage = new SignInPage();
        userHomePage = new UserHomePage();
    }

    @Step("Login")
    public void login() {
        goToSignInPage();
        selectUserType();
        setEmail();
        setPassword();
        clickOnSigIn();
        verifyUserSignedIn();
    }

    private void selectUserType() {
        signInPage.selectType(user.getType());
    }

    private void verifyUserSignedIn() {
        userHomePage.verifyRegisterStudentButtonVisible();
    }

    private void clickOnSigIn() {
        signInPage.signIn();
    }

    private void setPassword() {
        signInPage.setPassword(user.getPassword());
    }

    private void setEmail() {
        signInPage.setUsername(user.getEmail());
    }

    private void goToSignInPage() {
        landingPage.goToSignInPage();
    }
}
