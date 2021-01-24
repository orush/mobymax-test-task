package com.mobymax.automation.web.engine;

import com.codeborne.selenide.Configuration;
import com.mobymax.automation.config.ConfigProvider;
import com.mobymax.automation.web.engine.drivers.ChromeDriverProvider;

import java.time.Duration;
import java.util.Arrays;

public class DriverConfigurator {

    public static void configure() {
        Configuration.timeout = Duration.ofSeconds(ConfigProvider.CONFIG_PROPS.driverTimeout()).toMillis();
        Configuration.startMaximized = true;
        Configuration.reopenBrowserOnFail = true;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.browser = getDriverClassName();
    }

    private static String getDriverClassName() {
        String driverType = ConfigProvider.CONFIG_PROPS.driverType();
        DriverType driver = Arrays.stream(DriverType.values())
                .filter(it -> it.name().equals(driverType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Provided driver type is not supported\n" +
                        "Driver Type: " + driverType));
        switch (driver) {
            case chrome:
                return ChromeDriverProvider.class.getName();
            default:
                throw new IllegalArgumentException(String.format("No implementation for provided driver type: " +
                        "Driver Type[%s]", driverType));
        }
    }
}
