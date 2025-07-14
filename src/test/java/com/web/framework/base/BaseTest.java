package com.web.framework.base;

import com.web.framework.drivermanager.DriverFactory;
import com.web.framework.utils.ConfigReader;
import com.web.framework.utils.ExcelUtil;
import com.web.framework.utils.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners({com.web.framework.listeners.TestListener.class})
public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser, ITestContext context) {
        context.setAttribute("browser", browser);
        driver = DriverFactory.getDriver(browser);
        driver.get(ConfigReader.get("baseUrl"));
    }

    @DataProvider(name = "loginData", parallel = true)
    public Object[][] getLoginData() {
        String filePath = "src/test/resources/testdata/loginTestData.xlsx";
        return ExcelUtil.getSheetData(filePath, "Sheet1");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        DriverFactory.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void flushExtentReports() {
        ExtentManager.getInstance().flush(); // Important for cross-browser report
    }
}
