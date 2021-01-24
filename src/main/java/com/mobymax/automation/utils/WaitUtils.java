package com.mobymax.automation.utils;

import com.codeborne.selenide.Configuration;
import com.mobymax.automation.web.engine.DriverUtils;

import java.time.Duration;

public class WaitUtils {

    public static void untilElementsAppearInDom() {
        Runnable runnable = () -> {
            long start = DriverUtils.getDocumentElementsSize();
            sleep(200);
            long end = DriverUtils.getDocumentElementsSize();
            if (start != end) {
                throw new RuntimeException("Page wasn't loaded");
            }
        };
        until(runnable);
    }

    public static void until(Duration duration, Duration polling, Runnable runnable) {
        long end = laterBy(duration.toMillis());
        while (true) {
            try {
                runnable.run();
                return;
            } catch (AssertionError | RuntimeException e) {
                if (!isNowBefore(end)) {
                    throw new RuntimeException(e);
                }
            }
            sleep(polling.toMillis());
        }
    }

    public static void until(Runnable runnable) {
        until(Duration.ofMillis(Configuration.timeout), Duration.ofMillis(200), runnable);
    }

    private static long laterBy(long durationInMillis) {
        return System.currentTimeMillis() + durationInMillis;
    }

    private static boolean isNowBefore(long endInMillis) {
        return System.currentTimeMillis() < endInMillis;
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleep(Duration duration) {
        sleep(duration.toMillis());
    }
}
