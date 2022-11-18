@regression
Feature: test follow us
  Background:
    Given initialize follow us feature
 Scenario Outline: user clicks follow us icons
    When user clicks "<Icons>"
    Then user should go to selected "<page>"
   Examples:
   |Icons|      |page|
   |facebook|   |https://www.facebook.com/nopCommerce|
   |twitter|    |https://twitter.com/nopCommerce|
   |youtube|    |https://www.youtube.com/user/nopCommerce|
   |news|       |https://demo.nopcommerce.com/new-online-store-is-open|


