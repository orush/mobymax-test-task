package com.mobymax.automation.web.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.mobymax.automation.input.data.JobPosition;
import com.mobymax.automation.input.data.RegistrationType;
import com.mobymax.automation.input.data.School;
import com.mobymax.automation.input.data.State;
import com.mobymax.automation.web.pages.components.NestedRbtn;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LandingPage {
    private final SelenideElement header = $("#header"),
            signInBtn = header.$(".btn-signin"),
            registrationForm = $("#registration"),
            siteLinksContainer = registrationForm.$(".site-links-container"),
            firstNameInput = registrationForm.$("[name*=FirstName]"),
            lastNameInput = registrationForm.$("[name*=LastName]"),
            stateInput = registrationForm.$(".signup-input-state"),
            schoolInput = registrationForm.$("[name*=School]"),
            emailInput = registrationForm.$("[name*=Email]"),
            passwordInput = registrationForm.$("[name*=Password]"),
            registerFreeBtn = registrationForm.$("#register-button");
    private final ElementsCollection statesSelect = registrationForm.$$(".state-select .state-item"),
            schoolsSelect = registrationForm.$$(".school-select .school-item");
    private final NestedRbtn workOptions = new NestedRbtn(
            registrationForm.$$(".school-select-item > .text"),
            it -> it.$$(".custom-radio > .bodyTextWhite")
    );

    @Step("Go to Sign In page")
    public SignInPage goToSignInPage() {
        signInBtn.click();
        return new SignInPage();
    }

    @Step("Select registration type")
    public LandingPage selectRegistrationType(RegistrationType type) {
        SelenideElement el = siteLinksContainer.$$("a").find(exactText(type.getValue()));
        el.should(visible);
        if (!el.is(cssClass("active"))) {
            el.click();
        }
        return this;
    }

    @Step("Select job position")
    public LandingPage selectJobPosition(JobPosition jobPosition) {
        workOptions.select(jobPosition.getJobType().getValue(), jobPosition.getValue());
        return this;
    }

    @Step("Set first name")
    public LandingPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Set last name")
    public LandingPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Select state")
    public LandingPage selectState(State state) {
        stateInput.click();
        statesSelect.find(exactText(state.getState())).click();
        return this;
    }

    @Step("Select school")
    public LandingPage selectSchool(School school) {
        schoolInput.setValue(school.getSchoolName());
        schoolsSelect.find(text(school.getSchoolName())).click();
        return this;
    }

    @Step("Set email")
    public LandingPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Set password")
    public LandingPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Click on register")
    public void clickOnRegister() {
        registerFreeBtn.click();
    }
}
