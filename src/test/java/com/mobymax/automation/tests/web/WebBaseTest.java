package com.mobymax.automation.tests.web;

import com.mobymax.automation.listeners.TestListener;
import com.mobymax.automation.web.engine.DriverBinaryManager;
import com.mobymax.automation.web.engine.DriverConfigurator;
import com.mobymax.automation.web.engine.DriverUtils;
import lombok.extern.java.Log;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Log
@Listeners(TestListener.class)
public class WebBaseTest {

    @BeforeSuite(alwaysRun = true, description = "Download web driver binaries")
    protected void beforeSuite(ITestContext context) {
        DriverBinaryManager.setupWebDriverBinary();//download web driver binary
    }

    @BeforeMethod(alwaysRun = true, description = "Initialize web driver configuration")
    protected void beforeMethod() {
        DriverConfigurator.configure();//this method doesn't open the browser yet
    }

    @AfterMethod(alwaysRun = true, description = "Close driver")
    protected void tearDown() {
        DriverUtils.stop();
    }
}
