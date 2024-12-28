package com.TestAutomation.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;


    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read config file");
        }
    }

    // Method to get a property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Method to get the Login URL
    public static String getLoginUrl() {
        return getProperty("login.url");
    }

    // Method to get the Signup URL
    public static String getSignupUrl() {
        return getProperty("signup.url");
    }

    public static String getHomeUrl(){
        return getProperty("home.url");
    }

    // Methods to get login credentials
    public static String getEmail() {
        return getProperty("emailid");
    }

    public static String getFirstname() {
        return getProperty("firstname");
    }

    public static String getLastname() {
        return getProperty("lastname");
    }
    public static String getPassword() {
        return getProperty("password");
    }

    public static String getConfirmPassword() {
        return getProperty("confirmpassword");
    }

}
