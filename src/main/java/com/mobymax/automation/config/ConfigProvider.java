package com.mobymax.automation.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static final ConfigProps CONFIG_PROPS;

    static {
        String configDir = "src/test/resources/config/";
        Environment env = Environment.getByCommandLineProp();
        switch (env) {
            case dev:
                ConfigFactory.setProperty("env.config.path", configDir + "/" + env + ".properties");
                break;
            default:
                throw new RuntimeException("Provide implementation for '" + env + "' environment");
        }
        ConfigFactory.setProperty("common.config.path", configDir + "/common.properties");
        CONFIG_PROPS = ConfigFactory.create(ConfigProps.class, System.getProperties());
    }
}
