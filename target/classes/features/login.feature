@regression
Feature: Test Login Functionality
  Background:
    Given initialize login feature
 Scenario: Enter Valid Data
    When enter email "ahmed@tamer.com" and password "ahmed12"
    And press login
    Then user go to home page

  Scenario: Enter invalid Data
    When enter email "stay@gmail.com" and password "sss"
    And press login
    Then check on error message
    
  Scenario: Enter invalid email form
    When enter email "stay" and password "qwwe"
    Then check on email error message

  Scenario: user forget Password
    When user press forget password
    And user enter email "ahmed@tamer.com"
    And press recover button
    Then user gets instructions message has been sent
