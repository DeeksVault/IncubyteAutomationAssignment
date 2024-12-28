package com.TestAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators for the login page
    private By usernameField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.id("send2");
    private By emailError = By.id("email-error");
    private By passwordError = By.id("pass-error");
    private By inValidCredentialsError = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(WebDriver driver , String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(WebDriver driver , String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton(WebDriver driver) {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
    }

    public boolean checkInvalidCredentialsError(WebDriver driver){
        WebElement invalidCredentialsErrorText = driver.findElement(inValidCredentialsError);
        return invalidCredentialsErrorText.isDisplayed();
    }

    public boolean checkEmptyFields(WebDriver driver){
        WebElement passwordErrorText = driver.findElement(passwordError);
        WebElement emailErrorText = driver.findElement(emailError);
        return passwordErrorText.isDisplayed() || emailErrorText.isDisplayed();
    }

    public void login(String username, String password , WebDriver driver) {
        enterUsername(driver , username);
        enterPassword(driver , password);
        clickLoginButton(driver);
    }
}
