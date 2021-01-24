package com.mobymax.automation.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:${env.config.path}",
        "file:${common.config.path}"
})
public interface ConfigProps extends Config {

    @Key("driver.type")
    String driverType();

    @Key("driver.timeout")
    int driverTimeout();

    @Key("heavy.operation.timeout")
    int heavyOperationTimeout();

    @Key("web.url")
    String webUrl();
}
