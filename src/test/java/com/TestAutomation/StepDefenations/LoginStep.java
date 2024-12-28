package com.TestAutomation.StepDefenations;

import com.TestAutomation.Pages.LoginPage;
import com.TestAutomation.Utils.ConfigReader;
import com.TestAutomation.Utils.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;


public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    WebDriverManager driverManager;

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        try{
            System.out.println("in given");
            driverManager = new WebDriverManager();
            driver = driverManager.getDriver();
            String loginUrl = ConfigReader.getLoginUrl();
            if (loginUrl == null) {
                throw new IllegalArgumentException("Login URL is not set in config.properties");
            }
            System.out.println("Login URL: " + loginUrl);

            driver.get(loginUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }

    @When("I enter valid login credentials")
    public void iEnterValidLoginCredentials() {
        loginPage = new LoginPage(driver);
        System.out.println("in when");
        String username = ConfigReader.getEmail();
        String password = ConfigReader.getPassword();
        loginPage.login(username, password , driver);
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        System.out.println("in then");
        System.out.println("logged in successfully");
//        assertTrue("Test case successfull for valid login" , driver.getCurrentUrl() == ConfigReader.getHomeUrl());
        driverManager.quitDriver();
    }

    @When("I enter invalid login credentials")
    public void iEnterInvalidLoginCredentials(){
        loginPage = new LoginPage(driver);
        System.out.println("in when");
        String username = ConfigReader.getEmail();
        username = username+'a';
        String password = ConfigReader.getPassword();
        password = password + 'a';
        loginPage.login(username, password , driver);
    }


    @Then("I should be thrown with an error")
    public void iShouldBeThrownWithAnError(){
        System.out.println("not logged in successfully");
        System.out.println("in then");

        assertTrue("not logged in successfully", loginPage.checkInvalidCredentialsError(driver) || loginPage.checkEmptyFields(driver) );
        driverManager.quitDriver();
    }

    @When("I enter invalid email")
    public void iEnterInvalidEmail(){
        loginPage = new LoginPage(driver);
        System.out.println("in when");
        String email = ConfigReader.getEmail();
        email = email+'a';
        String password = ConfigReader.getPassword();
        loginPage.login(email, password , driver);
    }

    @When("I enter invalid password")
    public void iEnterInvalidPassword(){
        loginPage = new LoginPage(driver);
        System.out.println("in when");
        String email = ConfigReader.getEmail();
        String password = ConfigReader.getPassword();
        password = password+'a';
        loginPage.login(email, password , driver);
    }
    @When("I enter nothing")
    public void iEnterNothing(){
        loginPage = new LoginPage(driver);
        System.out.println("in when");
        String email = "";
        String password = "";
        loginPage.login(email, password , driver);
    }

}
