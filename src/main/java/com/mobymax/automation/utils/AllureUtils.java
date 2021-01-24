package com.mobymax.automation.utils;

import com.mobymax.automation.web.engine.DriverUtils;
import io.qameta.allure.Attachment;

public class AllureUtils {

    @Attachment("{name}")
    public static byte[] takeScreenshot(String name) {
        return DriverUtils.getScreenshot();
    }
}
