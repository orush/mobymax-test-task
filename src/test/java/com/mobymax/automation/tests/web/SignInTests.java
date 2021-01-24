package com.mobymax.automation.tests.web;

import com.mobymax.automation.input.data.Constants;
import com.mobymax.automation.models.UserModel;
import com.mobymax.automation.tests.web.providers.SignInProvider;
import com.mobymax.automation.web.features.LoginFeature;
import com.mobymax.automation.web.features.OpenAppFeature;
import com.mobymax.automation.web.features.RegisterNewUserFeature;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SignInTests extends WebBaseTest {

    @Description("User can sign in")
    @Test(groups = {Constants.REGRESSION_TEST_NG_GROUP},
            dataProvider = "signIn",
            dataProviderClass = SignInProvider.class)
    public void signIn(UserModel user) {
        new OpenAppFeature().open();
        new RegisterNewUserFeature(user).register();
        tearDown();
        new OpenAppFeature().open();
        new LoginFeature(user).login();
    }
}
