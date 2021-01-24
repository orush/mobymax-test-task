package com.mobymax.automation.web.engine;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public class SelenideElementUtils {

    public static void clearInputByKeys(SelenideElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
