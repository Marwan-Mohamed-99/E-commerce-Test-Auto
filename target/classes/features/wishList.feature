@regression
Feature: test wish list
  Background:
    Given initialize wish list feature
  Scenario: test add HTC to wish list
    When user select to add HTC phone to wish list
    Then user should get a success message

  Scenario: check on wish list cart
  When user select to add HTC phone to wish list
    And click on wish list
   Then user should find the product