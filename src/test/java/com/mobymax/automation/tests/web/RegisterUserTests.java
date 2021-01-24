package com.mobymax.automation.tests.web;

import com.mobymax.automation.input.data.Constants;
import com.mobymax.automation.models.UserModel;
import com.mobymax.automation.tests.web.providers.RegisterUserProvider;
import com.mobymax.automation.web.features.OpenAppFeature;
import com.mobymax.automation.web.features.RegisterNewUserFeature;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class RegisterUserTests extends WebBaseTest {

    @Description("Register new user")
    @Test(groups = {Constants.REGRESSION_TEST_NG_GROUP},
            dataProvider = "registerNewUser",
            dataProviderClass = RegisterUserProvider.class)
    public void registerNewUser(UserModel user) {
        new OpenAppFeature().open();
        new RegisterNewUserFeature(user).register();
    }
}
