@regression
Feature: test currency
  Background:
    Given initialize Currencies feature
  Scenario: change currency to euro
    When user press on currencies
    And user chooses "euro"
    Then the product currency changes to "euro"