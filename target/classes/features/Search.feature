@regression
Feature: test search
  Background:
    Given initialize Search feature
  Scenario Outline: : search products with name
    When user types "<productName>"
    And clicks on search
    Then user should find the "<productName>"
    Examples:
    |productName|
    |gift card|
    |laptop|
    |nike|

  Scenario Outline: : search products with sku
    When user types "<productSku>" as product sku
    And clicks on search
    Then user should find the "<productSku>" as product sku
    Examples:
      |productSku|
      |IF_YOU_WT|
      |COMP_CUST|
      |AP_MBP_13|