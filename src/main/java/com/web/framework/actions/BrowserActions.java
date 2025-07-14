package com.web.framework.actions;

import com.web.framework.utils.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserActions {

    private WebDriver driver;
    private WebDriverWait wait;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(WebElement element) {
        ExtentLogger.logInfo("Clicking on element: " + element.toString());
        waitUntilClickable(element).click();
    }

    public void type(WebElement element, String text) {
        ExtentLogger.logInfo("Typing text into element: " + element.toString());
        waitUntilVisible(element).clear();
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        ExtentLogger.logInfo("Getting text from : " + element.toString());
        return waitUntilVisible(element).getText();
    }

    public boolean isVisible(WebElement element) {
        try {
            ExtentLogger.logInfo("Verifying visibility of " + element.toString());
            return waitUntilVisible(element).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleContains(expectedTitle));
    }

}
