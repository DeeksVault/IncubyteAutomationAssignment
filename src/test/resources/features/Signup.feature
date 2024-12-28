@SmokeTest
Feature: User Signup Functionality

  Scenario: Successful Signup with valid credentials
    Given I navigate to the signup page
    When I enter valid signup credentials
    Then I should be signedup successfully


  Scenario: Failed signup with invalid email
    Given I navigate to the signup page
    When I enter invalid email in signup
    Then I should be thrown with an error in signup

  Scenario: Failed Signup with empty fields
    Given I navigate to the signup page
    When I enter nothing in signup
    Then I should be thrown with an error in signup