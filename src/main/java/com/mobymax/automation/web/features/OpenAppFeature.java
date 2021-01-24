package com.mobymax.automation.web.features;

import com.codeborne.selenide.Selenide;
import com.mobymax.automation.config.ConfigProvider;
import io.qameta.allure.Step;

public class OpenAppFeature {
    private final String url;

    public OpenAppFeature() {
        url = ConfigProvider.CONFIG_PROPS.webUrl();
    }

    @Step("Open application")
    public void open() {
        Selenide.open(url);
    }
}
