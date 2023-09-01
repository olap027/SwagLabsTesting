Feature: Checkout: Your Information" page

  Background: User Login
    Given The user is logged in
    * Click Login

  @SC_TC_023
  Scenario: As a user who did not fill in the first name field, I should not be able to proceed to Checkout: Overview page
    Given Ready to checkout all orders in the cart
    When I input the last name and zip code only
    And click continue
    Then Error message will be displayed "Error: First Name is required"

  @SC_TC_024
  Scenario: As a user who did not fill in the last name field, I should not be able to proceed to Checkout: Overview page
    Given Ready to checkout all orders in the cart
    When I input the first name and zip code only
    And click continue
    Then Error message will be displayed "Error: Last Name is required"

  @SC_TC_025
  Scenario: As a user who did not fill in the zip code field, I should not be able to proceed to Checkout: Overview page
    Given Ready to checkout all orders in the cart
    When I input the first name and last name only
    And click continue
    Then Error message will be displayed "Error: Postal Code is required"

  @SC_TC_026
  Scenario: As a user who filled out all the required fields, I should be able to proceed to Checkout: Overview page
    Given Ready to checkout all orders in the cart
    When I input valid information for checkout
    And click continue
    Then User will be redirected to page "https://www.saucedemo.com/checkout-step-two.html"

  @SC_TC_027
  Scenario: As a user I should be able to see all the products I checked out in Checkout: Overview page
    Given Ready to checkout all orders in the cart
    When I input valid information for checkout
    And click continue
    Then All the products I checked out should be listed in the page

  @SC_TC_028
  Scenario: As a user, I should be able to see the item total of the products I will purchase
    Given Ready to checkout all orders in the cart
    When I input valid information for checkout
    And click continue
    Then Item total should display the sum of all products

  @SC_TC_029
  Scenario: As a user, I should be able to see the total of items total and tax
    Given Ready to checkout all orders in the cart
    When I input valid information for checkout
    And click continue
    Then Total should display the sum of item total and tax

  @SC_TC_030
  Scenario: As a user, I should be able to cancel the transaction
    Given Ready to checkout all orders in the cart
    When I input valid information for checkout
    And click continue
    And click cancel
    Then User will be redirected to page "https://www.saucedemo.com/inventory.html"













