package com.TestAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
    private WebDriver driver;

    // Locators for the login page
    private By firstnameField = By.id("firstname");
    private By lastnameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By submitButton = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private By emailErrortext = By.id("email_address-error");
    private By passwordConfirmationErrorText = By.id("password-confirmation-error");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(WebDriver driver , String firstname , String lastname) {
        WebElement firstnameElement = driver.findElement(firstnameField);
        firstnameElement.clear();
        firstnameElement.sendKeys(firstname);
        WebElement lastnameElement = driver.findElement(lastnameField);
        lastnameElement.clear();
        lastnameElement.sendKeys(lastname);

    }

    public void enterEmail(WebDriver driver , String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(WebDriver driver , String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void confirmPassword(WebDriver driver , String password) {
        WebElement confirmpasswordElement = driver.findElement(confirmPasswordField);
        confirmpasswordElement.clear();
        confirmpasswordElement.sendKeys(password);
    }

    public void clickSignupButton(WebDriver driver) {
        WebElement submitElement = driver.findElement(submitButton);
        submitElement.click();
    }



    public void signup(String firstname , String lastname, String password , String confirmpassword , String email , WebDriver driver) {
        enterUsername(driver , firstname , lastname);
        enterEmail(driver , email);
        enterPassword(driver , password);
        confirmPassword(driver , confirmpassword);
        clickSignupButton(driver);
    }
}