package com.TestAutomation.StepDefenations;

import com.TestAutomation.Pages.LoginPage;
import com.TestAutomation.Pages.SignupPage;
import com.TestAutomation.Utils.ConfigReader;
import com.TestAutomation.Utils.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class SignupStep {
    WebDriver driver;
    SignupPage signupPage;
    WebDriverManager driverManager;

    @Given("I navigate to the signup page")
    public void iNavigateToTheSignupPage() {
        try{
            System.out.println("in given");
            driverManager = new WebDriverManager();
            driver = driverManager.getDriver();
            String signupUrl = ConfigReader.getSignupUrl();
            if (signupUrl == null) {
                throw new IllegalArgumentException("signup URL is not set in config.properties");
            }
            System.out.println("Signup URL: " + signupUrl);

            driver.get(signupUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @When("I enter valid signup credentials")
    public void iEnterValidSignupCredentials() {
        signupPage = new SignupPage(driver);
        System.out.println("in when");
        String firstname = ConfigReader.getFirstname();
        String lastname = ConfigReader.getLastname();
        String email = ConfigReader.getEmail();
        String password = ConfigReader.getPassword();
        String confirmpassword = ConfigReader.getConfirmPassword();
        signupPage.signup(firstname , lastname , password , confirmpassword , email , driver);
    }

    @Then("I should be signedup successfully")
    public void iShouldBeSignedupSuccessfully() {
        System.out.println("in then");
        System.out.println("logged in successfully");
        assertTrue("Test case successfull for valid login" , driver.getCurrentUrl() == ConfigReader.getHomeUrl());
        driverManager.quitDriver();
    }



    @Then("I should be thrown with an error in signup")
    public void iShouldBeThrownWithAnErrorInSignup(){
        System.out.println("not logged in successfully");
        System.out.println("in then");
        String email = ConfigReader.getEmail();
        String password = ConfigReader.getPassword();
        String confirmpassword = ConfigReader.getConfirmPassword();
        assertTrue("email has not matched the pattern" , !Pattern.matches(".*@.*\\\\..*" , email)); // check if email is of correct pattern
        assertTrue("password has not matched and length is less than 8" , !(password.equals(confirmpassword) && password.length()>8)); // check if password passes all the checks

        driverManager.quitDriver();
    }

    @When("I enter invalid email in signup")
    public void iEnterInvalidEmailInSignup(){
        signupPage = new SignupPage(driver);
        System.out.println("in when");
        String firstname = ConfigReader.getFirstname();
        String lastname = ConfigReader.getLastname();
        String email = ConfigReader.getEmail();
        email = email+'a';
        String password = ConfigReader.getPassword();
        String confirmpassword = ConfigReader.getConfirmPassword();
        signupPage.signup(firstname , lastname , password , confirmpassword , email , driver);
    }

    @When("I enter nothing in signup")
    public void iEnterNothingInSignup(){
        signupPage = new SignupPage(driver);
        System.out.println("in when");
        String firstname = "";
        String lastname = "";
        String email = "";
        String password = "";
        String confirmpassword = "";
        signupPage.signup(firstname , lastname , password , confirmpassword , email , driver);
    }
}
