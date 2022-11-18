@regression
Feature: test register
  Background:
    Given initialize register feature
   Scenario: Register with valid data
     When user press register icon
     And user selects "male" and enters "ahmed" as first name, "tamer" as last name, "ahmed@tamer.com" as email, "sss" as company, "ahmed12" as password and "ahmed12" as confirm password
     And user set his birthday as follow "10" Day "7" Month "1994" Year
     And user clicks on register button
     Then successful registration message appears

  Scenario: user didn't enter any data
     When user press register icon
     And user clicks on register button
     Then error messages appear

  Scenario: user didn't enter the same password
    When user press register icon
    And user selects "male" and enters "ahmed" as first name, "tamer" as last name, "ahmed@attia.com" as email, "sss" as company, "ahmed12" as password and "ahmed1" as confirm password
    And user set his birthday as follow "10" Day "7" Month "1994" Year
    And user clicks on register button
    Then user get non identical passwords

  Scenario: email already exist
  When user press register icon
   And user selects "male" and enters "ahmed" as first name, "tamer" as last name, "ahmed@tamer.com" as email, "sss" as company, "ahmed12" as password and "ahmed12" as confirm password
    And user set his birthday as follow "10" Day "7" Month "1994" Year
    And user clicks on register button
   Then email exist message appears






