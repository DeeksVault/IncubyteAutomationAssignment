@SmokeTest
Feature: User Login Functionality

  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    When I enter valid login credentials
    Then I should be logged in successfully

  Scenario: Failed Login with invalid credentials
    Given I navigate to the login page
    When I enter invalid login credentials
    Then I should be thrown with an error

  Scenario: Failed Login with invalid email
    Given I navigate to the login page
    When I enter invalid email
    Then I should be thrown with an error

  Scenario: Failed Login with invalid password
    Given I navigate to the login page
    When I enter invalid password
    Then I errorshould be thrown with an

  Scenario: Failed Login with empty fields
    Given I navigate to the login page
    When I enter nothing
    Then I should be thrown with an error