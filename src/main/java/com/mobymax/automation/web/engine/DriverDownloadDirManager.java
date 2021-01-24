package com.mobymax.automation.web.engine;

import java.nio.file.Path;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class DriverDownloadDirManager {
    private static final ThreadLocal<Path> paths = new ThreadLocal<>();

    public static Path get() {
        return paths.get();
    }

    public static Path clearSetGet() {
        paths.remove();
        paths.set(Path.of("", "target", randomAlphabetic(10)));
        return get();
    }
}
