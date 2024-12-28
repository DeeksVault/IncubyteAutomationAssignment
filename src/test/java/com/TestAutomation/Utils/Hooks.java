package com.TestAutomation.Utils;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;


    public void setUp() {
        driver = WebDriverManager.getDriver();
        System.out.println("Driver initialized before scenario.");
    }


    public void tearDown() {
        WebDriverManager.quitDriver();
        System.out.println("Driver closed after scenario.");
    }
}
