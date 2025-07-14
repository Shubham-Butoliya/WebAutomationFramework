package com.web.framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.web.framework.base.BaseTest;
import com.web.framework.drivermanager.DriverFactory;
import com.web.framework.utils.ExtentLogger;
import com.web.framework.utils.ExtentManager;
import com.web.framework.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        ExtentLogger.setTest(test);
        ITestContext context = result.getTestContext();
        String browser = (String) context.getAttribute("browser");

        test.assignCategory(browser);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getCurrentDriver();
        ExtentLogger.logFail(result.getThrowable().toString());
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        if (screenshotPath != null) {
            try {
                ExtentLogger.getTest().fail("Screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                ExtentLogger.logWarning("Failed to attach screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.logWarning("Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
//        ExtentLogger.clear();
        ExtentLogger.clear();
        ExtentManager.getInstance().flush();
    }

}
