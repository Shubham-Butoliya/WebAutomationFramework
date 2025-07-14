package com.web.framework.tests;

import com.web.framework.base.BaseTest;
import com.web.framework.listeners.RetryAnalyzer;
import com.web.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyLoginPageTitleTest() {
        String expectedTitle = "Swag Labs";
        LoginPage loginPage = new LoginPage(driver);
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginAs("testuser", "testpass");

        String expectedTitle = "Swag Labs1"; // Post-login title
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Login failed or wrong redirect");
    }

    @Test(dataProvider = "loginData")
    public void loginDataDrivenTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(username, password);

        // Optional: Add validation after login
        System.out.println("Logged in with: " + username + " / " + password);
    }
}
