package com.mobymax.automation.listeners;

import com.mobymax.automation.utils.AllureUtils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            if (testResult.getStatus() == ITestResult.FAILURE) {
                AllureUtils.takeScreenshot(testResult.getMethod().getMethodName());
            }
        }
    }
}
