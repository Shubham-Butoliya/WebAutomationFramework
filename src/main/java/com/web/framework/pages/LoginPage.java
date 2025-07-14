package com.web.framework.pages;

import com.web.framework.actions.BrowserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    private BrowserActions actions;

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.actions = new BrowserActions(driver);
    }

    public void enterUsername(String username) {
        actions.type(usernameInput, username);
    }

    public void enterPassword(String password) {
        actions.type(passwordInput, password);
    }

    public void clickLogin() {
        actions.click(loginButton);
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
